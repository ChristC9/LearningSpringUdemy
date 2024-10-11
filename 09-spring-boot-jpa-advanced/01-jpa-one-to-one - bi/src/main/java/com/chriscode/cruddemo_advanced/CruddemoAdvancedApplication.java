package com.chriscode.cruddemo_advanced;

import com.chriscode.cruddemo_advanced.dao.AppDAO;
import com.chriscode.cruddemo_advanced.entity.Instructor;
import com.chriscode.cruddemo_advanced.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoAdvancedApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{

//			findInstructorDetailsById(appDAO);
			deleteInstructorDetailsById(appDAO);
		};
	}

	private void deleteInstructorDetailsById(AppDAO appDAO) {

		int theId = 4;
		System.out.println("Removing the related id "+ theId);
		appDAO.deleteInstructorDetails(theId);
		System.out.println("Id " + theId + " is removed successfully");


	}

	private void findInstructorDetailsById(AppDAO appDAO) {

		int theId = 3;
		InstructorDetails tempIns = appDAO.findbyId(theId);
		System.out.println("Finding the instructor details id "+ theId);
		System.out.println("Final result is "+ tempIns);
		System.out.println("The answer is "+ tempIns.getInstructor());


	}


}
