package com.chriscode.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice best tennis for 15 mins.";
    }
}
