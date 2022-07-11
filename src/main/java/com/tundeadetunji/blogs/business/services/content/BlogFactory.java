package com.tundeadetunji.blogs.business.services.content;

import com.tundeadetunji.blogs.business.models.Blog;
import com.tundeadetunji.blogs.business.repositories.BlogRepository;
import com.tundeadetunji.blogs.business.utilities.Support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BlogFactory<T> {
    ArrayList<Blog> blogs;
    BlogRepository repo;

    public BlogFactory(BlogRepository repo, ArrayList<Blog> blogs) {
        this.blogs = blogs;
        this.repo = repo;
    }

    public BlogFactory(BlogRepository repo) {
        this.blogs = blogs(repo);
        this.repo = repo;
    }

    public ArrayList<Blog> blogs(BlogRepository repo) {
        ArrayList<Blog> blogs = new ArrayList<Blog>();

        Iterable<Blog> blogIterable = repo.findAll();
        Iterator<Blog> blogIterator = blogIterable.iterator();

        while (blogIterator.hasNext()) {
            blogs.add(blogIterator.next());
        }

        return blogs;
    }

    private ArrayList<T> getIds(Support.category category) throws Exception {
        ArrayList<T> ids = new ArrayList<T>();
        if (blogs.size() < 1) {
            throw new Exception("Cannot loop through ArrayList: it's empty!");
        }
        for (Blog blog : blogs) {
            if (blog.getCategory().equalsIgnoreCase(category.toString())) {
                ids.add((T) blog.getId());
            }
        }
        return ids;
    }

    private ArrayList<Blog> getBlogs(Support.category category, Long howManyToReturn, Boolean sort_ascending_not_descending) throws Exception {
        ArrayList<T> unsorted_ids = getIds(category);
        ArrayList<T> ids = sorted(unsorted_ids, sort_ascending_not_descending);
        ArrayList<Blog> sorted = new ArrayList<Blog>();

        Long exactlyHowManyToReturn = howManyToReturn;
        if (howManyToReturn == null) {
            exactlyHowManyToReturn = Long.valueOf(ids.size());
        }

        for (T i : ids) {
            Long id = (Long) i;
            sorted.add(repo.findById(id).get());
            if (sorted.size() == exactlyHowManyToReturn) {
                break;
            }
        }

        return sorted;
    }

    /**
     * Gets Blogs, intended for Search functionality.
     * @param term what user enters to search for
     * @return ArrayList of type Blog
     */
    public ArrayList<Blog> getBlogs(String term) {
        ArrayList<Blog> sought = new ArrayList<Blog>();

        if (term.isEmpty()){
            sought = blogs;
        }

        try {
            if (repo.findById(Long.valueOf(term)).isPresent()) {
                sought.add(repo.findById(Long.valueOf(term)).get());
                return sought;
            }
        } catch (Exception exception) {

        }

        Iterator iterator = blogs.iterator();
        while (iterator.hasNext()) {
            Blog blog = (Blog) iterator.next();
            if (blog.getTitle().equalsIgnoreCase(term) ||
                    blog.getPublished().equalsIgnoreCase(term) ||
                    blog.getAuthor().equalsIgnoreCase(term) ||
                    blog.getUuid().equalsIgnoreCase(term) ||
                    blog.getCategory().equalsIgnoreCase(term)) {
                sought.add(blog);
            }
        }
        return sought;
    }

    public ArrayList<Blog> businesses(Long howManyToReturn, Boolean sort_ascending_not_descending) throws Exception {
        return getBlogs(Support.category.business, howManyToReturn, sort_ascending_not_descending);
    }

    public ArrayList<Blog> cultures(Long howManyToReturn, Boolean sort_ascending_not_descending) throws Exception {
        return getBlogs(Support.category.culture, howManyToReturn, sort_ascending_not_descending);
    }

    public ArrayList<Blog> lifestyles(Long howManyToReturn, Boolean sort_ascending_not_descending) throws Exception {
        return getBlogs(Support.category.lifestyle, howManyToReturn, sort_ascending_not_descending);
    }

    /*
        support
    */

    @Override
    public String toString() {
        return "ArrayList<getClass().getName()>.size() is " + blogs.size();
    }

    private ArrayList<T> sorted(ArrayList<T> arrayListToSort, Boolean sorted_ascending) {
        if (sorted_ascending == true) {
            return sortAscending(arrayListToSort);
        }
        return sortDescending(arrayListToSort);
    }

    private ArrayList<T> sortAscending(ArrayList<T> arrayListToSort) {
        Collections.sort((List) arrayListToSort);
        return arrayListToSort;
    }

    private ArrayList<T> sortDescending(ArrayList<T> arrayListToSort) {
        Collections.sort(arrayListToSort, Collections.reverseOrder());
        return arrayListToSort;
    }
}
