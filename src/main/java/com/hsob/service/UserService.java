package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.users.Address;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author carlos
 */

@Service
public class UserService extends DAO {

    public void saveUser(User user, String password, String confirmPassword) {
        if (password.isEmpty() || password.equals(confirmPassword)){
            if (password.isEmpty()){
                password = "123";
            }
            if (!user.getGenderIdentity().isEmpty()){
                user.setSex(user.getGender());
            }
            if (!user.getSocialName().isEmpty()){
                user.setName(user.getSocialName());
            }
            if (!user.getGender().isEmpty()){
                user.setSex(user.getGender());
            }
            if (user.getUsername().isEmpty()){
                user.setUsername(user.getDocument());
            }

            String salt = Utils.generateSalt();
            String digest = Utils.generateDigest(password, salt);

            user.setSalt(salt);
            user.setDigest(digest);

            hsobdb.save(user, "user");

        } else {
            String msg = "password and confirm password do not match";
            logger.error(msg);
            throw new IllegalArgumentException(msg);
        }
    }


    public void updateAddress(Address address, String password, String username) {
        try{
            Criteria criteria =  Criteria.where("username").is(username);
            Query query = new Query(criteria);

            User user = hsobdb.findOne(query, User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }

            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                Update update = new Update();
                update.set("address", address);

                hsobdb.upsert(query, update, User.class);

                logger.info("Address updated");
            } else{
                logger.error("invalid password");
                throw new IllegalArgumentException("invalid password");
            }

        } catch (Exception e){
            logger.error(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
