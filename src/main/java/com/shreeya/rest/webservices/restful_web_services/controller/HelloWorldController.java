package com.shreeya.rest.webservices.restful_web_services.controller;

import com.shreeya.rest.webservices.restful_web_services.Model.AuthenticationBean;
import org.springframework.web.bind.annotation.*;

@RestController

//controller ofr handling http request
public class HelloWorldController {
//get
    //uri /hello-world

    @GetMapping("/hello-world")
public String helloWorld() {
   return "message!!";
}
@GetMapping("/hello-world-bean")
public AuthenticationBean AuthenticationBean() {

   return new AuthenticationBean("message!!");
}

@GetMapping("/hello-world/{name}")
public AuthenticationBean AuthenticationBeanPathVariable(@PathVariable String name) {
   return new AuthenticationBean(String.format("message!!, %s",name));
}


}
