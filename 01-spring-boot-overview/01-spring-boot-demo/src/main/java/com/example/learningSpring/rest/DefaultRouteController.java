package com.example.learningSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRouteController {
    @GetMapping("/")
    public String defaultRoute(){

        return "Welcome to the default route";

    }
}
