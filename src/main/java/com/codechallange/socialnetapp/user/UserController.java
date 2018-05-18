package com.codechallange.socialnetapp.user;


import com.codechallange.socialnetapp.twit.Twit;
import org.springframework.web.bind.annotation.*;

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
}
