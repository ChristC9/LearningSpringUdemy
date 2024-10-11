package com.chriscode.springcodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {
//				"com.chriscode.springcodedemo",
//				"com.chriscode.util"
//		}
//)
@SpringBootApplication
public class SpringcodedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcodedemoApplication.class, args);
	}

}
