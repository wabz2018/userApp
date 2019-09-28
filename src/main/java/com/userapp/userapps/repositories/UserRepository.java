/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.repositories;

import com.userapp.userapps.entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Maelo
 */
public interface UserRepository extends JpaRepositoryImplementation<Users, Long> {
  @Query("SELECT u FROM Users u WHERE u.username = :username")
    Users findByUsername(@Param("username")String Username);
   @Query("SELECT u FROM Users u WHERE u.password = :password")
      Users findByPassword(@Param("password")String password);
    
}
