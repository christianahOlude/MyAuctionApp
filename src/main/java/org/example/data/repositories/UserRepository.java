package org.example.data.repositories;

import org.example.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findUserById(String id);
    boolean existsUserByEmailAddress(String emailAddress);
}
