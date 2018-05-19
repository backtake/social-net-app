package com.codechallange.socialnetapp.user;

import com.codechallange.socialnetapp.twit.Twit;
import com.codechallange.socialnetapp.twit.TwitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        Collections.sort(twits);
        return twits;
    }

    @Override
    public void postMessage(Twit twit) {
        this.twitRepository.save(twit);
    }

    @Override
    public Set<User> findAllFollowedByUser(Long id) {
        User user = this.userRepository.findUserById(id);
        Set<User> followed = user.getFollowed();
        return followed;
    }

    @Override
    public void addUserToFollowed(Long id, Long toBeFollowedId) {
        User user = this.userRepository.findUserById(id);
        User userToBeFollowed = this.userRepository.findUserById(toBeFollowedId);
        Set<User> followed = user.getFollowed();
        followed.add(userToBeFollowed);
        this.userRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        return this.userRepository.findUserById(id);
    }

    @Override
    public Iterable<Twit> getTimeline(Long id) {
        Set<User> followed = findAllFollowedByUser(id);
        return getAllTwitsOfFollowed(followed);
    }

    private List<Twit> getAllTwitsOfFollowed(Set<User> followed) {
        List<Twit> timeline = new ArrayList<>();
        for (User user: followed) {
            timeline.addAll(this.twitRepository.findAllByUser(user));
        }
        Collections.sort(timeline);
        return timeline;
    }
}
