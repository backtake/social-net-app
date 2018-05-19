package com.codechallange.socialnetapp.user;

import com.codechallange.socialnetapp.twit.Twit;
import com.codechallange.socialnetapp.twit.TwitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public void save(User user) {

        if(this.userRepository.findUserByName(user.getName()) == null) {
            this.userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User with that name already exists");
        }
    }

    @Override
    public List<Twit> getUserWall(Long id) {
        List<Twit> twits = this.twitRepository.findAllByUser(this.userRepository.findUserById(id));
        Collections.reverse(twits);
        return twits;
    }

    @Override
    public void postMessage(Twit twit) {
        this.twitRepository.save(twit);
    }
}
