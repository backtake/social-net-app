package com.codechallange.socialnetapp.user;


import com.codechallange.socialnetapp.twit.Twit;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany
//    private List<Twit> twits;

//    @OneToMany
//    private Set<User> followed;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Twit> getTwits() {
//        return this.twits;
//    }
//
//    public void setTwits(List<Twit> twits) {
//        this.twits = twits;
//    }

//    public Set<User> getFollowed() {
//        return followed;
//    }
//
//    public void setFollowed(Set<User> followed) {
//        this.followed = followed;
//    }
}
