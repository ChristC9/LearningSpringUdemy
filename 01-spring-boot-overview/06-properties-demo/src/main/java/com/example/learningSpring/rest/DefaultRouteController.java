package com.example.learningSpring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRouteController {

    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose a new team info endpoint

    @GetMapping("/teaminfo")
    public String getTeamInfo() {

        return "Coach: " + coachName + ", Team name: " + teamName;

    }


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
