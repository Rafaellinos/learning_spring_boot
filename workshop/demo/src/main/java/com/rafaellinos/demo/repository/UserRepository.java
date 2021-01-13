package com.rafaellinos.demo.repository;

import com.rafaellinos.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // MongoRepository<User, String> -> precisa -> Classe e tipo do ID

}
