package com.codechallange.socialnetapp.user;

import com.codechallange.socialnetapp.twit.TwitRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TwitRepository twitRepository;

    public UserServiceImpl(UserRepository userRepository, TwitRepository twitRepository) {
        this.twitRepository = twitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }
}
