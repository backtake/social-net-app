package com.codechallange.socialnetapp.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findAll();
    User findUserByName(String name);
    User findUserById(Long id);
}
