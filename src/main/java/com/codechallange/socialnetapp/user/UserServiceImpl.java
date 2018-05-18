package com.codechallange.socialnetapp.user;

import com.codechallange.socialnetapp.twit.Twit;
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

    @Override
    public void save(User user) {

        if(this.userRepository.findUserByName(user.getName()) == null) {
            this.userRepository.save(user);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Twit> getUserWall(Long id) {
        return this.twitRepository.findAllByUser(this.userRepository.findUserById(id));
    }

    @Override
    public void postMessage(Long userId, Twit twit) {
        User user = this.userRepository.findUserById(userId);
        twit.setUser(user);
        this.twitRepository.save(twit);
    }
}
