package com.chriscode.springcodedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // define a private field for the dependency

    private  Coach myCoach;

    // define a constructor for dependency injection

    @Autowired
    public DemoRestController(Coach theCoach){

        myCoach = theCoach;

    }

    // define a method to expose a "REST" endpoint

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
