/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.repositories;

import com.userapp.userapps.entities.Blog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maelo
 */
@Repository
public interface BlogRespository extends JpaRepository<Blog, Long> {

    @Query("SELECT b FROM Blog b WHERE b.title = :title")
    List<Blog> findByTitle(@Param("title") String title);

    // custom query to search to blog post by title or content
//    @Query("SELECT b FROM Blog b WHERE b.id = :id")
//    public Blog findOne(int id);
//
//    @Query("DELETE b FROM Blog b WHERE b.id = :id")
//    public void delete(int id);
}
