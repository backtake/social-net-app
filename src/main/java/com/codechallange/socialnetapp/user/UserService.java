package com.codechallange.socialnetapp.user;

import com.codechallange.socialnetapp.twit.Twit;

public interface UserService {

    Iterable<User> findAll();
    void save(User user);
    Iterable<Twit> getUserWall(Long id);
    void postMessage(Long userId, Twit twit);
}
