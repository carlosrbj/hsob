package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.users.Address;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

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
            User user = hsobdb.findOne(new Query(Criteria.where("username").is(username)), User.class);
            if (user == null){
                throw new IllegalArgumentException("User not found");
            }
            boolean validPassword = Utils.validatePassword(password, user);

            if (validPassword){
                Update update = new Update();
                update.set("address", address);

                hsobdb.upsert(new Query(Criteria.where("username").is(username)), update, User.class);

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

    public void imageTo64Base(MultipartFile file, String username) throws IOException {

//        String photo = String.valueOf(file.getInputStream());

//        File outputFile = new File(System.getProperty("java.io.tmpdir"), String.valueOf(file.getInputStream()));
//        file.transferTo(outputFile);
//
//        FileInputStream fileInputStreamReader = new FileInputStream(outputFile);
//        byte[] bytes = new byte[(int)outputFile.length()];
//        fileInputStreamReader.read(bytes);
        String photo = new String(Base64.encodeBase64(file.getBytes()), Charset.defaultCharset());

        Update update = new Update();
        update.set("photo", photo);

        hsobdb.upsert(new Query(Criteria.where("username").is(username)), update, User.class);

    }
}
