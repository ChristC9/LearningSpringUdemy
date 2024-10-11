package com.chriscode.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice best cricket for 15 mins.";
    }

}
