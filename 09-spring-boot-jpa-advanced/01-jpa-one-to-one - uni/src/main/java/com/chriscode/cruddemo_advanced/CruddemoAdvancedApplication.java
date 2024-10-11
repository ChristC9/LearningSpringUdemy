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
			createInstructor(appDAO);

//			findInstructorById(appDAO);

//			deleteInstructorById(appDAO);

		};
	}

	private void deleteInstructorById(AppDAO appDAO) {

		int theId = 2;
		appDAO.deleteInstructorbyId(theId);
		System.out.println("Deleted instructor with id: " + theId);

	}

	private void findInstructorById(AppDAO appDAO) {

		Instructor specificInstructor = appDAO.findInstrutorById(1);
		System.out.println("Found instructor: " + specificInstructor);

	}

	private void createInstructor(AppDAO appDAO) {

		// create an instructor
		Instructor tempInstructor = new Instructor("Nyan Htet", "Aung", "nha@gmail.com");

		InstructorDetails tempInstructorDetails = new InstructorDetails("youtube.com/nha", "coding/chilling");

		// associate the objects

		tempInstructor.setInstructorDetails(tempInstructorDetails);

		// save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Saved instructor: " + tempInstructor);
	}
}
