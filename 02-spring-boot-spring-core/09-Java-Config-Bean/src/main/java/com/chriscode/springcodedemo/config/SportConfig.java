package com.chriscode.springcodedemo.config;


import com.chriscode.springcodedemo.common.Coach;
import com.chriscode.springcodedemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

//    @Bean   // @Bean has default id. Default id is the method name. Or you can specify the id with @Bean("desiredId")
    @Bean("swimCoachBeanId")  // @Bean with specified id.
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
