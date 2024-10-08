package com.shreeya.rest.basic.auth.controller;


import com.shreeya.rest.webservices.restful_web_services.Model.AuthenticationBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationBean authenticationBean(){
        return new AuthenticationBean("you are authenticated");
    }

}
