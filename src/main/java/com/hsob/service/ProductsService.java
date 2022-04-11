package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.products.Category;
import com.hsob.model.products.Product;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService extends DAO {

    public void saveNewProduct(Product product, String password, String username) {
        try {
            User user = hsobdb.findOne(new Query(Criteria.where("username").is(username)), User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                product.setProductId(createProductId());
                product.setCreationDate(System.currentTimeMillis());
                hsobdb.save(product);
                logger.info("Product saved: " + product);
            } else {
                logger.error("Invalid password");
                throw new IllegalArgumentException("Invalid password");
            }
        } catch (Exception exception){
            logger.error(exception.getMessage());
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    private String createProductId(){
        String productId= Utils.generateAlphaNumericString(6);
        while (checkExistingProductId(productId)){
            productId= Utils.generateAlphaNumericString(6);
        }
        return productId;
    }

    private boolean checkExistingProductId(String productId){
        Criteria criteria = Criteria.where("productId").is(productId);
        Query query = new Query(criteria);
        Product product = hsobdb.findOne(query, Product.class);
        if (product ==  null){
            return false;
        }
        return true;
    }

    private boolean checkExistingProductByName(Product product){
        Product productFind = hsobdb.findOne(new Query(Criteria.where("name").is(product.getName())), Product.class);
        if (productFind ==  null){
            return false;
        }
        return true;
    }


    public List<Product> getProductByCategory(String categoryId, String password, String username) {
        try {
            User user = hsobdb.findOne(new Query(Criteria.where("username").is(username)), User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                return hsobdb.find(new Query(Criteria.where("categories.categoryId").is(categoryId)), Product.class);
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
