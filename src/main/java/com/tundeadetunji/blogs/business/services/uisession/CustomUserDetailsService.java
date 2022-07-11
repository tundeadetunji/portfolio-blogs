package com.tundeadetunji.blogs.business.services.uisession;

import com.tundeadetunji.blogs.business.models.User;
import com.tundeadetunji.blogs.business.repositories.UserRepository;
import com.tundeadetunji.blogs.business.policies.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository repo;
//    ApplicationContext context;
//    UserFactory factory;

    /*
     * username is replaced by email
     * @param username email
     * @return CustomUserDetails object
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new CustomUserDetails(user);
    }


}
