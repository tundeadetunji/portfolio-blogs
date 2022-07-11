package com.tundeadetunji.blogs.business.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tundeadetunji.blogs.business.models.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {
    
}
