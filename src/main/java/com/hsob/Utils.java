package com.hsob;

import java.security.SecureRandom;
import java.util.Random;

import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.jasypt.digest.StandardStringDigester;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author carlos
 */

public class Utils {
    protected static final Log logger = LogFactory.getLog(Utils.class);
    private static final String CHARS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String NUMBERS = "1234567890";
    private static final String ALGORITHM = "SHA-256";
    private static final int ITERATIONS = 5000;

    @Autowired
    static MongoTemplate hsobdb;


    public static String generateSalt() {
        Random random = new SecureRandom();
        int passwordSize = 10;
        StringBuilder buff = new StringBuilder();
        for (int j = 0; j < (passwordSize / 2); j++) {
            buff.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        for (int j = 0; j < (passwordSize / 2); j++) {
            buff.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        return buff.toString().replace("+", "A");
    }

    public static String generateDigest(String password, String salt) {
        StandardStringDigester digester = new StandardStringDigester();
        digester.setAlgorithm(ALGORITHM);
        digester.setIterations(ITERATIONS);
        digester.setSaltGenerator(new StringFixedSaltGenerator(salt));
        return digester.digest(password);
    }

    public static boolean validatePassword(String password, User user){
        try{
            String digest = Utils.generateDigest(password, user.getSalt());

            if (user.getDigest().equals(digest)){
                return true;
            }
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        return false;
    }
}
