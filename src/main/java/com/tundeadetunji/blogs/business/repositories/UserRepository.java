package com.tundeadetunji.blogs.business.repositories;

import com.tundeadetunji.blogs.business.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Needed for ui login.
     * @param email
     * @return
     */
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User getUser(String email);

    User findByUsername(String username);

}
