/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.controllers;

import com.userapp.userapps.entities.Users;
import com.userapp.userapps.services.UserService;
import com.userapp.userapps.utils.GeneralRequest;
import com.userapp.userapps.utils.GeneralResponseController;
import com.userapp.userapps.utils.UserRequest;
import com.userapp.userapps.utils.UserResponseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ;
 *
 * @author Maelo
 */
@RestController
@RequestMapping("/api/users")
@Api(value = "users", description = "checklogins")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Login users",notes = "Login users")

    public UserResponseController loginController(@RequestBody UserRequest userRequest, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        return new UserResponseController(service.userLogin(userRequest), HttpStatus.OK);
    }
       @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Add users",notes = "Add users")

    public GeneralResponseController register(@RequestBody GeneralRequest<Users> generalRequest, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        return new GeneralResponseController(service.register(generalRequest), HttpStatus.OK);
    }
}
