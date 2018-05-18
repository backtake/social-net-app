package com.codechallange.socialnetapp.twit;

import com.codechallange.socialnetapp.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitRepository extends CrudRepository<Twit, Long> {

    Iterable<Twit> findAllByUser(User user);
}
