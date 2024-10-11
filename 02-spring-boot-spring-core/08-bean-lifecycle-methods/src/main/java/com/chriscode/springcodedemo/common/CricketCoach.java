package com.chriscode.springcodedemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    // init method for bean lifecycle while the application is running

    @PostConstruct
    public void doMydailyStuff(){
        System.out.println("In PostConstruct: " + getClass().getSimpleName());
    }

    // destroy method for bean lifecycle when the application is shutting down
    @PreDestroy
    public void doMyDailyCleanup(){
        System.out.println("In PreDestroy: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice best cricket for 15 mins.";
    }

}
