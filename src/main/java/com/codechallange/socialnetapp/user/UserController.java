package com.codechallange.socialnetapp.user;


import com.codechallange.socialnetapp.twit.Twit;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public Iterable<User> index() {
        return this.service.findAll();
    }

    @PostMapping(path = "")
    public User create(@RequestBody User user) {
        this.service.save(user);
        return user;
    }

    @GetMapping(path = "/{id}")
    public Iterable<Twit> showUserWall(@PathVariable Long id) {
        return this.service.getUserWall(id);
    }

    @PostMapping(path = "/{id}")
    public Twit twitMessage(@RequestBody Twit twit) {
        this.service.postMessage(twit);
        return twit;
    }

    @GetMapping(path = "/{id}/followed")
    public Iterable<Twit> showTimeline(@PathVariable Long id) {
        return this.service.getTimeline(id);
    }

    @PutMapping(path = "/{id}/followed/{toBeFollowedId}")
    public User addToFollowed(@PathVariable Long id, @PathVariable Long toBeFollowedId) {
        this.service.addUserToFollowed(id, toBeFollowedId);
        return this.service.findOne(id);
    }
}
