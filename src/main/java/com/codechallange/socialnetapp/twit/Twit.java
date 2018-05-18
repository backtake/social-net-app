package com.codechallange.socialnetapp.twit;

import com.codechallange.socialnetapp.user.User;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Twit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Calendar date;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Twit() {}

    public Twit(Calendar date, String message, User user) {
        this.date = date;
        this.message = message;
        this.user = user;
    }
}
