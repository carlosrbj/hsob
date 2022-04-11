package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.products.Product;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ProductsService extends DAO {



    public void saveNewProduct(Product product, String password, String username) {
        try {
            User user = Utils.validateUser(username);
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                hsobdb.save(product);
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
