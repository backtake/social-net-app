package com.codechallange.socialnetapp.user;

import com.codechallange.socialnetapp.twit.Twit;

import java.util.Set;

public interface UserService {

    Iterable<User> findAll();
    void save(User user);
    Iterable<Twit> getUserWall(Long id);
    void postMessage(Twit twit);
    Set<User> findAllFollowedByUser(Long id);
    void addUserToFollowed(Long id, Long userId);
    User findOne(Long id);
    Iterable<Twit> getTimeline(Long id);
}
