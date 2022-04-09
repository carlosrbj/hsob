package com.hsob.repository;

import com.hsob.model.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author carlos
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
