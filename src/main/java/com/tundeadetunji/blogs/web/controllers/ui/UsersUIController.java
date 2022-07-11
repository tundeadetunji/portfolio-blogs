package com.tundeadetunji.blogs.web.controllers.ui;

import com.tundeadetunji.blogs.business.models.User;
import com.tundeadetunji.blogs.business.repositories.UserRepository;
import com.tundeadetunji.blogs.business.services.apisession.UserService;
import com.tundeadetunji.blogs.business.services.content.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.tundeadetunji.blogs.business.policies.General.userRoles.USER;

@Controller
public class UsersUIController {

    @Autowired
    ApplicationContext context;

    UserFactory userFactory;

    @GetMapping("/register")
    public String ShowRegisterForm(Model model) {
        userFactory = new UserFactory();
        model.addAttribute("user", new User());
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "RegisterUserForm";
    }

    @PostMapping("/users/add")
    public String AddUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        UserRepository repo = context.getBean(UserRepository.class);

        if (new UserFactory(repo).userExists(user.getEmail())) {
            redirectAttributes.addFlashAttribute("message", "This email has already been registered by another user. Please choose another email!");
            return "redirect:/register";
        }

        user.setUsername(user.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);

        context.getBean(UserService.class).addRoleToUser(user.getEmail(), USER.toString());

        return "redirect:/index";
    }
}
