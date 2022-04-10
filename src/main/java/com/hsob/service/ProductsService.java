package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.products.Category;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ProductsService extends DAO {

    public void createCategory(String category, String password, String username) {
        try {
            Criteria criteria =  Criteria.where("username").is(username);
            Query query = new Query(criteria);

            User user = hsobdb.findOne(query, User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                Category newCategory = new Category();
                newCategory.setName(category);
                newCategory.setCategoryId(createCategoryId());
                hsobdb.save(newCategory);
                logger.error("category saved");
            } else {
                logger.error("Invalid password");
            }

        } catch (Exception exception){
            logger.error(exception.getMessage());
            throw new IllegalArgumentException(exception.getMessage());

        }
    }

    private String createCategoryId(){
        String categoryId= Utils.generateAlphaNumericString(6);
        while (checkExistingCategory(categoryId)){
            categoryId= Utils.generateAlphaNumericString(6);
        }
        return categoryId;
    }

    private boolean checkExistingCategory(String categoryId){
        Criteria criteria = Criteria.where("categoryId").is(categoryId);
        Query query = new Query(criteria);
        Category category = hsobdb.findOne(query, Category.class);
        if (category ==  null){
            return false;
        }
        return true;
    }
}
