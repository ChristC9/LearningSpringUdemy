package com.chriscode.springcodedemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements  Coach{

    public FootballCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice best football for 15 mins.";
    }
}
