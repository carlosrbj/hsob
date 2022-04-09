package com.hsob;

import java.security.SecureRandom;
import java.util.Random;
import org.jasypt.digest.StandardStringDigester;
import org.jasypt.salt.StringFixedSaltGenerator;

/**
 * @author carlos
 */

public class Utils {
    private static final String CHARS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String NUMBERS = "1234567890";
    private static final String ALGORITHM = "SHA-256";
    private static final int ITERATIONS = 5000;

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
}
