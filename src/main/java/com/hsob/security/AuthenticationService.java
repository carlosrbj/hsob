package com.hsob.security;

import com.hsob.Utils;
import com.hsob.model.users.User;
import com.hsob.repository.DAO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService extends DAO implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = hsobdb.findOne(new Query(Criteria.where("username").is(username)), User.class);
        if (user == null){
            return user;
        }
        throw new IllegalArgumentException("User not found");
    }
}
