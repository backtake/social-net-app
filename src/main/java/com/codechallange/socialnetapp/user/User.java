package com.codechallange.socialnetapp.user;


import com.codechallange.socialnetapp.twit.Twit;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Twit> twits;

    @OneToMany
    private Set<User> followed;

    protected User() {}

    public User(String name) {
        this.name = name;
    }
}
