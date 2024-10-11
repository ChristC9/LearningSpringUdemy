package com.chriscode.cruddemo;

import com.chriscode.cruddemo.dao.StudentDAO;
import com.chriscode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

//			createSingleStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// Read the student object from the database by id
//			findStudentById(studentDAO);

			// Read all student objects from the database
//			findAllStudents(studentDAO);

			// Find students by last name
//			findStudentByLastName(studentDAO);

			// Update student object

//			updateStudent(studentDAO);

//			removeStufromDb(studentDAO);
		};
	}

	private void removeStufromDb(StudentDAO studentDAO) {

		int id = 3;

		studentDAO.delete(id);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int stuId = 1;
		Student stu = studentDAO.findById(stuId);
		stu.setFirstName("Christopher");
		stu.setLastName("Wik");
		stu.setEmail("christopherJohn@gmail.com");

		studentDAO.update(stu);
		System.out.println("The updated student is :" + stu);
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findbyLastName("Aung");
		for (Student student: students){
			System.out.println("Student found: " + student);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {


		// Get a list of students
		List <Student> students = studentDAO.findAll();

		// Display the students list
		for (Student student: students){
			System.out.println("Student found: " + student);
		}


	}

	//  Read the student object from the database by id
	private void findStudentById(StudentDAO studentDAO) {

		Student stu1 = studentDAO.findById(1);
//		System.out.println("Student found: " + stu1.getFirstName() + " " + stu1.getLastName());
		System.out.println("Student found: " + stu1);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Create 3 new students obj ...");
		Student stu1 = new Student("John", "Doe","jd@gmail.com");
		Student stu2 = new Student("Mary", "Lane", "marrylane@outlook.com");
		Student stu3 = new Student("Nyan Htet", "Aung", "nha@gmail.com");
		System.out.println("Students obj created ...");

		ArrayList<Student> studentArrayList = new ArrayList<>();
		studentArrayList.add(stu1);
		studentArrayList.add(stu2);
		studentArrayList.add(stu3);

		for (int i = 0; i < studentArrayList.size(); i++) {

			System.out.println("Save students obj ...");
			studentDAO.save(studentArrayList.get(i));
			System.out.println("Student object saved with id: " + studentArrayList.get(i).getId());
		}



	}

	private void createSingleStudent(StudentDAO studentDAO) {
		System.out.println("Create a new student obj ...");
		Student stu1 = new Student("Chris", "James","chrisj@gmail.com");
		System.out.println("Student obj created ...");

		System.out.println("Save student obj ...");
		studentDAO.save(stu1);

		System.out.println("Student object saved with id: " + stu1.getId());
	}
}
