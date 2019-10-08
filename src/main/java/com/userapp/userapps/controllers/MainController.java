/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userapp.userapps.controllers;

import com.userapp.userapps.entities.Subprice;
import com.userapp.userapps.entities.Subtypes;
import com.userapp.userapps.services.MainService;
import com.userapp.userapps.utils.GeneralRequest;
import com.userapp.userapps.utils.GeneralResponseController;
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
public class MainController {

    @Autowired
    MainService service;

    //save new plan
    @RequestMapping(value = "/saveplan", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Add New Plan", notes = "Add Plans")

    public GeneralResponseController saveplan(@RequestBody GeneralRequest<Subtypes> generalRequest, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        return new GeneralResponseController(service.SaveType(generalRequest), HttpStatus.OK);
    }
//view plans

    @RequestMapping(value = "/lisplans", method = RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "List plans", notes = "List plans")

    public GeneralResponseController listplans(@RequestBody GeneralRequest<Subtypes> generalRequest, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        return new GeneralResponseController(service.findAllTypes(generalRequest), HttpStatus.OK);
    }
//add price

    @RequestMapping(value = "/saveprice", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Add New Price", notes = "Add Price")

    public GeneralResponseController saveprice(@RequestBody GeneralRequest<Subprice> generalRequest, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        return new GeneralResponseController(service.SavePrice(generalRequest), HttpStatus.OK);
    }
//view prices

    @RequestMapping(value = "/lisprices", method = RequestMethod.GET, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "List prices", notes = "List prices")

    public GeneralResponseController listprices(@RequestBody GeneralRequest<Subprice> generalRequest, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        return new GeneralResponseController(service.findAllPrices(generalRequest), HttpStatus.OK);
    }

}
