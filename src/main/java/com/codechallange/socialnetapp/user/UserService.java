package com.codechallange.socialnetapp.user;

public interface UserService {

    Iterable<User> findAll();
    void save(User user);

}
