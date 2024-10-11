package com.chriscode.springcodedemo.rest;

import com.chriscode.springcodedemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class DemoRestController {

    // define a private field for the dependency

    private Coach myCoach;
    private Logger logger = Logger.getLogger(getClass().getName());

    // define a constructor for dependency injection
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In Constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    // define a method to expose a "REST" endpoint

    @GetMapping("/workout")
    public String getDailyWorkout(){
        logger.info("GET /workout");
        return myCoach.getDailyWorkout();
    }

}
