package com.tundeadetunji.blogs;

import com.tundeadetunji.blogs.business.models.Blog;
import com.tundeadetunji.blogs.business.models.User;
import com.tundeadetunji.blogs.business.repositories.BlogRepository;
import com.tundeadetunji.blogs.business.repositories.UserRepository;
import com.tundeadetunji.blogs.business.services.apisession.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.tundeadetunji.blogs.business.policies.General.userRoles.BLOGGER;

@SpringBootApplication
public class BlogsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BlogsApplication.class, args);

        InitialDBData initial = new InitialDBData();
        UserRepository userRepository = context.getBean(UserRepository.class);
        if (userRepository.count() == 0) {
            userRepository.save(initial.user);
            context.getBean(UserService.class).addRoleToUser(initial.user.getEmail(), BLOGGER.toString());

        }

        BlogRepository blogRepository = context.getBean(BlogRepository.class);
        if (blogRepository.count() == 0){
            blogRepository.save(initial.blog_1);
            blogRepository.save(initial.blog_2);
            blogRepository.save(initial.blog_3);
            blogRepository.save(initial.blog_4);
            blogRepository.save(initial.blog_5);
            blogRepository.save(initial.blog_6);
            blogRepository.save(initial.blog_7);
            blogRepository.save(initial.blog_8);
            blogRepository.save(initial.blog_9);
        }

        System.out.println("App started...");
    }

}

class InitialDBData{
    public User user;

    public Blog blog_1;
    public Blog blog_2;
    public Blog blog_3;
    public Blog blog_4;
    public Blog blog_5;
    public Blog blog_6;
    public Blog blog_7;
    public Blog blog_8;
    public Blog blog_9;


    public InitialDBData() {
        user = new User();
        user.setEmail(user_email);
        user.setUsername(user_username);
        user.setFirstName(user_first_name);
        user.setLastName(user_last_name);
        user.setPassword(new BCryptPasswordEncoder().encode(user_password));

        blog_1 = new Blog();
        blog_1.setAuthor(blog_1_author);
        blog_1.setCategory(blog_1_category);
        blog_1.setTitle(blog_1_title);
        blog_1.setContent(blog_1_content);
        blog_1.setContentLead(blog_1_content_lead);

        blog_2 = new Blog();
        blog_2.setAuthor(blog_2_author);
        blog_2.setCategory(blog_2_category);
        blog_2.setTitle(blog_2_title);
        blog_2.setContent(blog_2_content);
        blog_2.setContentLead(blog_2_content_lead);

        blog_3 = new Blog();
        blog_3.setAuthor(blog_3_author);
        blog_3.setCategory(blog_3_category);
        blog_3.setTitle(blog_3_title);
        blog_3.setContent(blog_3_content);
        blog_3.setContentLead(blog_3_content_lead);

        blog_4 = new Blog();
        blog_4.setAuthor(blog_4_author);
        blog_4.setCategory(blog_4_category);
        blog_4.setTitle(blog_4_title);
        blog_4.setContent(blog_4_content);
        blog_4.setContentLead(blog_4_content_lead);

        blog_5 = new Blog();
        blog_5.setAuthor(blog_5_author);
        blog_5.setCategory(blog_5_category);
        blog_5.setTitle(blog_5_title);
        blog_5.setContent(blog_5_content);
        blog_5.setContentLead(blog_5_content_lead);

        blog_6 = new Blog();
        blog_6.setAuthor(blog_6_author);
        blog_6.setCategory(blog_6_category);
        blog_6.setTitle(blog_6_title);
        blog_6.setContent(blog_6_content);
        blog_6.setContentLead(blog_6_content_lead);

        blog_7 = new Blog();
        blog_7.setAuthor(blog_7_author);
        blog_7.setCategory(blog_7_category);
        blog_7.setTitle(blog_7_title);
        blog_7.setContent(blog_7_content);
        blog_7.setContentLead(blog_7_content_lead);

        blog_8 = new Blog();
        blog_8.setAuthor(blog_8_author);
        blog_8.setCategory(blog_8_category);
        blog_8.setTitle(blog_8_title);
        blog_8.setContent(blog_8_content);
        blog_8.setContentLead(blog_8_content_lead);

        blog_9 = new Blog();
        blog_9.setAuthor(blog_9_author);
        blog_9.setCategory(blog_9_category);
        blog_9.setTitle(blog_9_title);
        blog_9.setContent(blog_9_content);
        blog_9.setContentLead(blog_9_content_lead);

    }

    private String user_email = "demo@demo.com";
    private String user_username = "demo@demo.com";
    private String user_first_name = "Amy";
    private String user_last_name = "Last";
    private String user_password = "sequel";

    private String blog_1_author = "James Business";
    private String blog_1_category = "Business";
    private String blog_1_title = "The First Business";
    private String blog_1_content = "The First Business\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_1_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_2_author = "John Business";
    private String blog_2_category = "Business";
    private String blog_2_title = "The Second Business";
    private String blog_2_content = "The Second Business\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_2_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_3_author = "Janet Business";
    private String blog_3_category = "Business";
    private String blog_3_title = "The Third Business";
    private String blog_3_content = "The Third Business\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_3_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_4_author = "Jane Culture";
    private String blog_4_category = "Culture";
    private String blog_4_title = "The 1st Culture";
    private String blog_4_content = "The 1st Culture\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_4_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_5_author = "Amy Culture";
    private String blog_5_category = "Culture";
    private String blog_5_title = "The 2nd Culture";
    private String blog_5_content = "The 2nd Culture\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_5_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_6_author = "Janice Culture";
    private String blog_6_category = "Culture";
    private String blog_6_title = "The 3rd Culture";
    private String blog_6_content = "The 3rd Culture\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_6_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_7_author = "Sandra Lifestyle";
    private String blog_7_category = "Lifestyle";
    private String blog_7_title = "Lifestyle 1";
    private String blog_7_content = "Lifestyle 1\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_7_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_8_author = "Tanya Lifestyle";
    private String blog_8_category = "Lifestyle";
    private String blog_8_title = "Lifestyle 2";
    private String blog_8_content = "Lifestyle 2\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_8_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    private String blog_9_author = "Charlotte Lifestyle";
    private String blog_9_category = "Lifestyle";
    private String blog_9_title = "Lifestyle 3";
    private String blog_9_content = "Lifestyle 3\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    private String blog_9_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
}