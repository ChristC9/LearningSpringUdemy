package com.chriscode.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice best baseball for 15 mins.";
    }
}
