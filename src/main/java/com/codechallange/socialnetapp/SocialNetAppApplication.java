package com.codechallange.socialnetapp;

import com.codechallange.socialnetapp.twit.TwitRepository;
import com.codechallange.socialnetapp.user.User;
import com.codechallange.socialnetapp.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocialNetAppApplication {

//	private static final Logger log = LoggerFactory.getLogger(SocialNetAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SocialNetAppApplication.class, args);
	}

//	@Bean
//    public CommandLineRunner demo(UserRepository userRepository, TwitRepository twitRepository) {
//	    return (args) -> {
//	        userRepository.save(new User("Gienek"));
//	        userRepository.save(new User("Staszek"));
//	        userRepository.save(new User("Wacek"));
//
//	        log.info("Users found with findAll(): ");
//	        for(User user: userRepository.findAll()) {
//	            log.info(user.toString());
//            }
//        };
//    }
}
