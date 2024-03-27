package com.sreenu.online.ecommerce.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    protected final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/{user}")
    public String getLoginUser(@PathVariable String user){
        logger.info("Login user :: "+user);
        return user;
    }

}
