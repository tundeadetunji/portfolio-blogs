package com.tundeadetunji.blogs.business.services.content;

import com.tundeadetunji.blogs.business.models.User;
import com.tundeadetunji.blogs.business.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Iterator;

public class UserFactory {
    User user;
    UserRepository repo;

    public UserFactory(User user, UserRepository repo) {
        this.user = user;
        this.repo = repo;
    }

    public UserFactory(UserRepository repo) {
        this.repo = repo;
    }

    public UserFactory() {
    }

    public boolean userExists(String email) {
        boolean exists = false;
        Iterator<User> iterator = users().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEmail().equalsIgnoreCase(email)) {
                exists = true;
            }
        }
        return exists;
    }

    /**
     * Finds User with matching email.
     *
     * @param email email of the user.
     * @return User object with matching email.
     */
    public User getUser(String email) {
        Iterator<User> iterator = users().iterator();
        User sought = null;
        while (iterator.hasNext()) {
            if (iterator.next().getEmail().equalsIgnoreCase(email)) {
                sought = iterator.next();
            }
        }
        return sought;
    }

    /**
     * Finds User with matching email. Same as getUser().
     *
     * @param email email of the user.
     * @return User object with matching email.
     */
    public User getUserByEmail(String email) {
        return getUser(email);
    }

    public ArrayList<User> users() {
        ArrayList<User> usersFromORM = new ArrayList<User>();
        Iterable<User> iterable = repo.findAll();
        Iterator<User> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            usersFromORM.add(iterator.next());
        }
        return usersFromORM;
    }

    public boolean userIsLoggedIn() {
        return !sessionUsername().equalsIgnoreCase("") || sessionUsername().isEmpty();
    }


    public String loggedOnGreeting() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return "Welcome, " + ((UserDetails) principal).toString() + "!";
        } else {
            if (principal.toString().equalsIgnoreCase("anonymousUser")) {
                return "";
            } else {
                return "";
            }
            //return principal.toString();
        }
    }

    public String sessionUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).toString();
        } else {
            if (principal.toString().equalsIgnoreCase("anonymousUser")) {
                return "";
            } else {
                return "";
            }
            //return principal.toString();
        }
    }

}
