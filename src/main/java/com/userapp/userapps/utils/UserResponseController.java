/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Maelo
 */
public class UserResponseController extends ResponseEntity<UserResponse> {
    
    public UserResponseController(UserResponse userresponse, HttpStatus hs) {
        super(userresponse,hs);
    }
    
}
