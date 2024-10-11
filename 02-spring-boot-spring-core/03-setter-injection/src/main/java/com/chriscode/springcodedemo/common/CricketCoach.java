package com.chriscode.springcodedemo.common;

//@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice best bowling for 15 mins.";
    }

}
