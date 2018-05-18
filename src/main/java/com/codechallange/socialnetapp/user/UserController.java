package com.codechallange.socialnetapp.user;


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
}
