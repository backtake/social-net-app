package com.codechallange.socialnetapp;

import com.codechallange.socialnetapp.twit.Twit;
import com.codechallange.socialnetapp.twit.TwitRepository;
import com.codechallange.socialnetapp.user.User;
import com.codechallange.socialnetapp.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SocialNetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetAppApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(UserRepository userRepository, TwitRepository twitRepository) {
	    return (args) -> {
	        User user1 = new User("Han");
	        User user2 = new User("Dan");
	        User user3 = new User("Jan");
	        userRepository.save(user1);
	        userRepository.save(user2);
	        userRepository.save(user3);
            Twit twit1 = new Twit("wiadomosc1");
            Twit twit2 = new Twit("wiadomosc2");
            Twit twit3 = new Twit("wiadomosc3");
            Twit twit4 = new Twit("wiadomosc4");
            twit1.setUser(user1);
            twit2.setUser(user2);
            twit3.setUser(user3);
            twit4.setUser(user2);
            twitRepository.save(twit1);
            twitRepository.save(twit2);
            twitRepository.save(twit3);
            twitRepository.save(twit4);
            Set<User> followed1 = new HashSet<>();
            followed1.add(user2);
            followed1.add(user3);
            user1.setFollowed(followed1);
            userRepository.save(user1);
            Set<User> followed2 = new HashSet<>();
            followed2.add(user1);
            user2.setFollowed(followed2);
            userRepository.save(user2);
        };
    }
}
