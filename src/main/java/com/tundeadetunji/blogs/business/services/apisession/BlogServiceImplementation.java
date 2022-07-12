package com.tundeadetunji.blogs.business.services.apisession;

import com.tundeadetunji.blogs.business.models.Blog;
import com.tundeadetunji.blogs.business.repositories.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImplementation implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceImplementation(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }
}
