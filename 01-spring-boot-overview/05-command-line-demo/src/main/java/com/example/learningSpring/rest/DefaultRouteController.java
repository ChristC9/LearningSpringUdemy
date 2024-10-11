package com.example.learningSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRouteController {
    @GetMapping("/")
    public String defaultRoute(){

        return "Welcome to the default route";

    }
    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public  String getWorkout(){
        return "Daily Life Workout";
    }
    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
