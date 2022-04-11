package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.products.Category;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends DAO {

    public void createCategory(String category, String password, String username) {
        try {
            User user = hsobdb.findOne(new Query(Criteria.where("username").is(username)), User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                Category newCategory = new Category();
                if (!checkExistingCategoryByName(category)){
                    newCategory.setName(category);
                    newCategory.setCategoryId(createCategoryId());
                    hsobdb.save(newCategory);
                    logger.info("Category saved: " + category);
                } else {
                    logger.error("The category "+ category + " already exists");
                    throw new IllegalArgumentException("The category "+ category + " already exists");
                }
            } else {
                logger.error("Invalid password");
                throw new IllegalArgumentException("Invalid password");
            }

        } catch (Exception exception){
            logger.error(exception.getMessage());
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    private String createCategoryId(){
        String categoryId= Utils.generateAlphaNumericString(6);
        while (checkExistingCategoryId(categoryId)){
            categoryId= Utils.generateAlphaNumericString(6);
        }
        return categoryId;
    }

    private boolean checkExistingCategoryId(String categoryId){
        Criteria criteria = Criteria.where("categoryId").is(categoryId);
        Query query = new Query(criteria);
        Category category = hsobdb.findOne(query, Category.class);
        if (category ==  null){
            return false;
        }
        return true;
    }

    private boolean checkExistingCategoryByName(String name){
        Criteria criteria = Criteria.where("name").is(name);
        Query query = new Query(criteria);
        Category category = hsobdb.findOne(query, Category.class);
        if (category ==  null){
            return false;
        }
        return true;
    }

    public List<Category> getCategoriesList(String password, String username) {
        try {
            User user = hsobdb.findOne(new Query(Criteria.where("username").is(username)), User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                return hsobdb.findAll(Category.class);
            } else {
                logger.error("Invalid password");
                throw new IllegalArgumentException("Invalid password");
            }
        } catch (Exception exception){
            logger.error(exception.getMessage());
            throw new IllegalArgumentException(exception.getMessage());
        }

    }
}
