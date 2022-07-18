package com.arcade.blogapi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final BlogRepository repository;

    BlogController(BlogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<BlogModel> getBlogs() {
        return repository.findAll();
    }

    @PostMapping
    BlogModel createBlog(@RequestBody BlogModel newBlog) {
        return repository.save(newBlog);
    }

    @GetMapping("/{id}")
    Optional<BlogModel> getOneBlog(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Optional<Object> updateBlog(@RequestBody BlogModel newBlog, @PathVariable Long id) {
        return repository.findById(id).map((blog) -> {
            blog.setBlogTitle(newBlog.getBlogTitle());
            blog.setBlogText(newBlog.getBlogText());
            return repository.save(blog);
        });
    }

    @DeleteMapping("/{id}")
    void deleteBlog(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
