package com.tundeadetunji.blogs.web.controllers.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import com.tundeadetunji.blogs.business.services.content.BlogFactory;
import com.tundeadetunji.blogs.business.utilities.Support;
import com.tundeadetunji.blogs.business.services.content.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tundeadetunji.blogs.business.models.Blog;
import com.tundeadetunji.blogs.business.repositories.BlogRepository;

import static com.tundeadetunji.blogs.business.utilities.Support.*;

@Controller
public class BlogsUIController {

    @Autowired
    private ApplicationContext context;

    private static final String BLOG_NOT_FOUND = "Blog not found!";
    private UserFactory userFactory;

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

    @GetMapping("")
    public String ShowBlogsHomeWithEmptyString(Model model) throws Exception {
        return ShowBlogsHome(model);
    }

    @GetMapping("/")
    public String ShowBlogsHomeWithSlash(Model model) throws Exception {
        return ShowBlogsHome(model);
    }

    @GetMapping("/index")
    public String ShowBlogsHome(Model model) throws Exception {
        userFactory = new UserFactory();

        BlogRepository repo = context.getBean(BlogRepository.class);
        BlogFactory<Integer> factory;

        ArrayList<Blog> blogs = new ArrayList<Blog>();

        Iterable<Blog> blogIterable = repo.findAll();
        Iterator<Blog> blogIterator = blogIterable.iterator();

        while (blogIterator.hasNext()) {
            blogs.add(blogIterator.next());
        }
        factory = new BlogFactory<Integer>(repo, blogs);

        //blogs from orm
        ArrayList<Blog> hero_businesses = factory.businesses(3L, false);
        ArrayList<Blog> hero_cultures = factory.cultures(3L, false);
        ArrayList<Blog> hero_lifestyles = factory.lifestyles(3L, false);

        //attributes
        model.addAttribute("last_business_title",hero_businesses.get(0).getTitle());
        model.addAttribute("last_business_author",hero_businesses.get(0).getAuthor());
        model.addAttribute("last_business_published", toShortDate(hero_businesses.get(0).getPublished()));
        model.addAttribute("last_business_content", clipped(hero_businesses.get(0).getContent(), true));
        model.addAttribute("last_business_id", hero_businesses.get(0).getId());

        model.addAttribute("second_to_last_business_title",hero_businesses.get(1).getTitle());
        model.addAttribute("second_to_last_business_author",hero_businesses.get(1).getAuthor());
        model.addAttribute("second_to_last_business_published", toShortDate(hero_businesses.get(1).getPublished()));
        model.addAttribute("second_to_last_business_id",hero_businesses.get(1).getId());

        model.addAttribute("third_to_last_business_title",hero_businesses.get(2).getTitle());
        model.addAttribute("third_to_last_business_author",hero_businesses.get(2).getAuthor());
        model.addAttribute("third_to_last_business_published", toShortDate(hero_businesses.get(2).getPublished()));
        model.addAttribute("third_to_last_business_id",hero_businesses.get(2).getId());

        model.addAttribute("last_culture_title",hero_cultures.get(0).getTitle());
        model.addAttribute("last_culture_author",hero_cultures.get(0).getAuthor());
        model.addAttribute("last_culture_published", toShortDate(hero_cultures.get(0).getPublished()));
        model.addAttribute("last_culture_content", clipped(hero_cultures.get(0).getContent(), true));
        model.addAttribute("last_culture_id",hero_cultures.get(0).getId());

        model.addAttribute("second_to_last_culture_title",hero_cultures.get(1).getTitle());
        model.addAttribute("second_to_last_culture_author",hero_cultures.get(1).getAuthor());
        model.addAttribute("second_to_last_culture_published", toShortDate(hero_cultures.get(1).getPublished()));
        model.addAttribute("second_to_last_culture_id",hero_cultures.get(1).getId());

        model.addAttribute("third_to_last_culture_title",hero_cultures.get(2).getTitle());
        model.addAttribute("third_to_last_culture_author",hero_cultures.get(2).getAuthor());
        model.addAttribute("third_to_last_culture_published", toShortDate(hero_cultures.get(2).getPublished()));
        model.addAttribute("third_to_last_culture_id",hero_cultures.get(2).getId());

        model.addAttribute("last_lifestyle_title",hero_lifestyles.get(0).getTitle());
        model.addAttribute("last_lifestyle_author",hero_lifestyles.get(0).getAuthor());
        model.addAttribute("last_lifestyle_published", toShortDate(hero_lifestyles.get(0).getPublished()));
        model.addAttribute("last_lifestyle_content", clipped(hero_lifestyles.get(0).getContent(), true));
        model.addAttribute("last_lifestyle_id",hero_lifestyles.get(0).getId());

        model.addAttribute("second_to_last_lifestyle_title",hero_lifestyles.get(1).getTitle());
        model.addAttribute("second_to_last_lifestyle_author",hero_lifestyles.get(1).getAuthor());
        model.addAttribute("second_to_last_lifestyle_published", toShortDate(hero_lifestyles.get(1).getPublished()));
        model.addAttribute("second_to_last_lifestyle_id",hero_lifestyles.get(1).getId());

        model.addAttribute("third_to_last_lifestyle_title",hero_lifestyles.get(2).getTitle());
        model.addAttribute("third_to_last_lifestyle_author",hero_lifestyles.get(2).getAuthor());
        model.addAttribute("third_to_last_lifestyle_published", toShortDate(hero_lifestyles.get(2).getPublished()));
        model.addAttribute("third_to_last_lifestyle_id",hero_lifestyles.get(2).getId());

        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String ShowBlog(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        userFactory = new UserFactory();
        BlogRepository repo = context.getBean(BlogRepository.class);
        Optional<Blog> currentBlog = repo.findById(Long.valueOf(id));

        //check if id exists, else return to index
        if (!blogExists(id)){
            redirectAttributes.addFlashAttribute("message", BLOG_NOT_FOUND);
            return "redirect:/index";
        }

        Blog blog = currentBlog.get();
        model.addAttribute("title", blog.getTitle());
        model.addAttribute("category", blog.getCategory());
        model.addAttribute("published", toShortDate(blog.getPublished()));
        String content = blog.getContent();
        ArrayList<String> header = leftRightOfClipped(content);
        model.addAttribute("firstCharacter", header.get(0));
        model.addAttribute("restOfClipped", header.get(1));
        model.addAttribute("restAfterClipped", restAfterClipped(content));
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "blog";
    }

    @GetMapping("/{category}")
    public String ShowCategories(@PathVariable("category") String category, Model model, RedirectAttributes redirectAttributes) throws Exception {
        userFactory = new UserFactory();

        BlogRepository repo = context.getBean(BlogRepository.class);
        BlogFactory<Integer> factory;

        ArrayList<Blog> blogs = new ArrayList<Blog>();

        Iterable<Blog> blogIterable = repo.findAll();
        Iterator<Blog> blogIterator = blogIterable.iterator();

        while (blogIterator.hasNext()) {
            blogs.add(blogIterator.next());
        }
        factory = new BlogFactory<Integer>(repo, blogs);
        ArrayList<Blog> currentCategory = factory.lifestyles(null, false);

        if (category.equalsIgnoreCase(Support.category.business.toString())){
            currentCategory = factory.businesses(null, false);
        }
        else if (category.equalsIgnoreCase(Support.category.culture.toString())){
            currentCategory = factory.cultures(null, false);
        }

        model.addAttribute("blogs", currentCategory);
        model.addAttribute("category", category);
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());


        return "category";
    }

    @GetMapping("/about")
    public String ShowAbout(Model model){
        userFactory = new UserFactory();
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "about";
    }

    @GetMapping("/search")
    public String ShowSearchForm(Model model){
        userFactory = new UserFactory();
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "search";
    }

    @GetMapping("/search/results")
    public String ShowSearchResults(String term, Model model, RedirectAttributes redirectAttributes){
        userFactory = new UserFactory();

        ArrayList<Blog> results = new BlogFactory<Integer>(context.getBean(BlogRepository.class)).getBlogs(term);

        if (results == null){
            redirectAttributes.addFlashAttribute("message", "No results found for " + term + "!");
            return "redirect:/search";
        }
        if (results.size() < 1){
            redirectAttributes.addFlashAttribute("message", "No results found for " + term + "!");
            return "redirect:/search";
        }
        model.addAttribute("results", results);
        model.addAttribute("term", term);
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "searchResults";
    }

    @GetMapping("/contact")
    public String ShowContact(Model model){
        userFactory = new UserFactory();
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "contact";
    }

    @GetMapping("/new")
    public String ShowNewBlogForm(Model model) {
        userFactory = new UserFactory();
        model.addAttribute("blog", new Blog());
        model.addAttribute("business", category.business.toString());
        model.addAttribute("culture", category.culture.toString());
        model.addAttribute("lifestyle", category.lifestyle.toString());
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        return "NewBlogForm";
    }

    @GetMapping("/edit/{id}")
    public String ShowUpdateBlogForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        userFactory = new UserFactory();
        BlogRepository repo = context.getBean(BlogRepository.class);
        Optional<Blog> blog = repo.findById(Long.valueOf(id));

        if (!blog.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Blog doesn't exist!");
            return "redirect:/index";
        }

        Blog currentBlog = blog.get();
        model.addAttribute("blog", currentBlog);
        model.addAttribute("loggedOnGreeting", userFactory.loggedOnGreeting());
        model.addAttribute("sessionUsername", userFactory.sessionUsername());
        model.addAttribute("id", id);
        return "UpdateBlogForm";
    }

    @GetMapping("/blog/delete/{id}")
    public String DeleteBlog(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        //check if blog belongs to the logged on user
        if (!isOwnBlog()){
            redirectAttributes.addFlashAttribute("message", "Blog isn't yours, can't delete it!");
            return "redirect:/index";
        }

        BlogRepository repo = context.getBean(BlogRepository.class);
        Optional<Blog> blog = repo.findById(Long.valueOf(id));

        if (!blog.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Blog doesn't exist!");
            return "redirect:/index";
        }

        repo.deleteById(Long.valueOf(id));
        redirectAttributes.addFlashAttribute("message", "Blog deleted permanently!");
        return "redirect:/index";
    }

    private boolean isOwnBlog(){
        return true;
    }

    @PostMapping("/blog/add")
    public String AddBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        BlogRepository repo = context.getBean(BlogRepository.class);
        repo.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog has been added.");
        return "redirect:/index";
    }

    @PostMapping("/blog/update")
    public String UpdateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        BlogRepository repo = context.getBean(BlogRepository.class);
        Blog blog2update = repo.findById(blog.getId()).get();
        blog2update.setContent(blog.getContent());
        blog2update.setTitle(blog.getTitle());
        repo.save(blog2update);
        redirectAttributes.addFlashAttribute("message", "Blog has been updated.");
        return "redirect:/index";
    }

    private boolean blogExists(Integer id){
        BlogRepository repo = context.getBean(BlogRepository.class);
        Optional<Blog> blog = repo.findById(Long.valueOf(id));
        return blog.isPresent();
    }

}
