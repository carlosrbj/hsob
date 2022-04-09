package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.users.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;




@Service
public class UserService {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    MongoTemplate hsobdb;

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
}
