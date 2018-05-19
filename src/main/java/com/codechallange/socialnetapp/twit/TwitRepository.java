package com.codechallange.socialnetapp.twit;

import com.codechallange.socialnetapp.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitRepository extends CrudRepository<Twit, Long> {
    List<Twit> findAllByUser(User user);
}
