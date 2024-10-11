package com.chriscode.springcodedemo;
import org.springframework.stereotype.Component;

//@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice best bowling for 15 mins.";
    }

}
