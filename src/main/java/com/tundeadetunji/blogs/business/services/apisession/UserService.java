package com.tundeadetunji.blogs.business.services.apisession;

import com.tundeadetunji.blogs.business.models.Role;
import com.tundeadetunji.blogs.business.models.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    //List<User> getUsers();
}
