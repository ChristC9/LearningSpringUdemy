package com.chriscode.cruddemo_advanced;

import com.chriscode.cruddemo_advanced.dao.AppDAO;
import com.chriscode.cruddemo_advanced.entity.Course;
import com.chriscode.cruddemo_advanced.entity.Instructor;
import com.chriscode.cruddemo_advanced.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoAdvancedApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{

//			findInstructorDetailsById(appDAO);
//			deleteInstructorDetailsById(appDAO);

//			createCourseByInstructor(appDAO);

//			findCoursesByInstructor(appDAO);

//			CoursesByInstructorId(appDAO);

//			updateInstructor(appDAO);

//			updateCourse(appDAO);

			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;
		Instructor tempInstructor = appDAO.findInstructorbyId(id);
		// get courses from instructor and set instructor to null from Course table
		List<Course> courses = tempInstructor.getCourses();

		for (Course course : courses){
			course.setInstructor(null);
		}

		appDAO.deleteInsturctor(tempInstructor);

		System.out.println("Instructor id "+ id + " is deleted");

	}

	private void updateCourse(AppDAO appDAO) {

		int id = 1;
		Course tempCourse = appDAO.findCourseById(id);

		tempCourse.setTitle("How to code basic OOP using Python");

		appDAO.UpdateCourse(tempCourse);

		System.out.println("Update Query for Course is "+ tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {

//		Instructor instructor = new Instructor("Nyan Htet", "Aung", "nha@gmail.com");
//		appDAO.UpdateInstructor(instructor);

		int id = 1;
		Instructor instructor = appDAO.findInstructorbyId(id);

		instructor.setFirstName("Chris");
		instructor.setEmail("chris@gmail.com");

		appDAO.UpdateInstructor(instructor);

		System.out.println("Updated instructor query is "+ instructor);

	}

	private void CoursesByInstructorId(AppDAO appDAO) {

		int id = 1;

		Instructor instructor = appDAO.findInstructorbyId(id);

//		List <Course> coursesList = appDAO.findCoursesByInstructorId(id);
//
//		instructor.setCourses(coursesList);

		System.out.println("The result of the course with id number "+ id + " is " + instructor.getCourses());
	}

	private void findCoursesByInstructor(AppDAO appDAO) {

		int theId = 1;
		Instructor instructor = appDAO.findInstructorbyId(theId);
		System.out.println(" Result for instructor is "+ instructor);
		System.out.println(" Course Result - "+ instructor.getCourses());
	}

	private void createCourseByInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Hopeman", "Wick","hopmanwick@gmail.com");
		InstructorDetails instructorDetails = new InstructorDetails("www.youtube.com/hw","Coding");

		tempInstructor.setInstructorDetails(instructorDetails);

		Course tempCourse = new Course("How to Code");

		tempInstructor.add(tempCourse);

		appDAO.saveInstructor(tempInstructor);
		System.out.println("Final Associated Obj for Course is "+ tempCourse);
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
