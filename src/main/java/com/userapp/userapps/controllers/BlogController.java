/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.controllers;

import com.userapp.userapps.entities.Blog;
import com.userapp.userapps.repositories.BlogRespository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maelo
 */
@RestController
public class BlogController {

    @Autowired
    BlogRespository blogRespository;

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

//    @GetMapping("/blog/{id}")
//    public Blog show(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        return blogRespository.findOne(blogId);
//    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRespository.findByTitle(searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogRespository.save(new Blog(title, content));
    }

//    @PutMapping("/blog/{id}")
//    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
//        int blogId = Integer.parseInt(id);
//        // getting blog
//        Blog blog = blogRespository.findOne(blogId);
//        blog.setTitle(body.get("title"));
//        blog.setContent(body.get("content"));
//        return blogRespository.save(blog);
//    }
//
//    @DeleteMapping("blog/{id}")
//    public boolean delete(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        blogRespository.delete(blogId);
//        return true;
//    }
}