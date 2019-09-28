/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.services;

import com.userapp.userapps.entities.Users;
import com.userapp.userapps.repositories.UserRepository;
import com.userapp.userapps.utils.GeneralRequest;
import com.userapp.userapps.utils.GeneralRespose;
import com.userapp.userapps.utils.UserRequest;
import com.userapp.userapps.utils.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maelo
 */
@Service
public class UserService {

    UserResponse response;

    @Autowired
    UserRepository userrepos;

    public UserResponse userLogin(UserRequest userRequest) {
        response = new UserResponse();
        Users username = userrepos.findByUsername(userRequest.getUsername());
        Users password = userrepos.findByPassword(userRequest.getPassword());
        //response.setHttpStatus(HttpStatus.OK);
        response.setMessage("Invalid login credentials");
        response.setRequestStatus(Boolean.FALSE);
        response.setToken(null);

        if (username != null && password != null) {
          //  response.setHttpStatus(HttpStatus.OK);
            response.setMessage("Successfully Logged in");
            response.setRequestStatus(Boolean.TRUE);
            response.setToken("iuyiuuoluootrtrtiwyqio1152628272181719367192hj,hdqjw");
        } else {
         //   response.setHttpStatus(HttpStatus.OK);
            response.setMessage("Invalid login credentials");
            response.setRequestStatus(Boolean.TRUE);
            response.setToken(null);
        }

        return response;
    }

    public GeneralRespose register(GeneralRequest<Users> generalRequest) {
        GeneralRespose respose = new GeneralRespose();
        Users users = new Users();
        Users username = userrepos.findByUsername(generalRequest.getObject().getUsername());
        respose.setHttpStatus(HttpStatus.OK);
        respose.setMessage("Failed");
        respose.setPayload(null);
        respose.setStatus(true);
        if (username == null) {
            users.setFirstname(generalRequest.getObject().getFirstname());
            users.setLastname(generalRequest.getObject().getLastname());
            users.setUsername(generalRequest.getObject().getUsername());
            users.setToken(generalRequest.getObject().getToken());
            users.setIsloggedIn(Boolean.FALSE);
            userrepos.save(users);
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Success");
            respose.setPayload(users);
            respose.setStatus(true);

        } else {
            respose.setHttpStatus(HttpStatus.OK);
            respose.setMessage("Failed");
            respose.setPayload(null);
            respose.setStatus(true);
        }
        return respose;
    }

}
