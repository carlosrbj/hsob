package com.hsob.service;

import com.hsob.model.users.User;
import com.hsob.repository.UserRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user, String password) {
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


        user.setSalt(password.concat(" - ABC"));
        user.setDigest("CBA - ".concat(password));

        return userRepository.save(user);
    }
}
