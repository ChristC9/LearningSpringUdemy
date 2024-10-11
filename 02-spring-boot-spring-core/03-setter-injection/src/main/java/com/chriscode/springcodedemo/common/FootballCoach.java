package com.chriscode.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements  Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice best football for 15 mins.";
    }
}
