package com.codechallange.socialnetapp.twit;

import com.codechallange.socialnetapp.user.User;

import javax.persistence.*;

@Entity
public class Twit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setMessage(String message){
        if(message.length()<=140) {
            this.message = message;
        } else {
            throw new IllegalArgumentException("Your message is too big");
        }
    }

    public String getMessage() {
        return this.message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
