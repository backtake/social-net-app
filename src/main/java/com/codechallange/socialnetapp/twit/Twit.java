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
    @JoinColumn(name = "user_id")
    private User user;

    protected Twit() {}

    public Twit(String message) {
        setMessage(message);
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void setMessage(String message){
        if(message.length()<=140) {
            this.message = message;
        } else {
            throw new IllegalArgumentException("Your message is too big");
        }
    }
}
