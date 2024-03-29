package com.johnny.spring.cruddemo;

import com.johnny.spring.cruddemo.dao.StudentDAO;
import com.johnny.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;

		// Delete the student
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id; " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby"
		System.out.println("Updating student");
		myStudent.setFirstName("Paul");

		// Update the student
		studentDAO.update(myStudent);

		// Display updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		 // Get a List of students
		List<Student> theStudents = studentDAO.findByLastName("doe");

		// Display list of students
		theStudents.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		theStudents.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@example.com");

		// Save teh student
		System.out.println("Saving the student... ");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// Retrieve student based on the id: Primary key
		System.out.println("Retrieving student with the id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating new student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@example.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@example.com");
		Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@example.com");

		// Save the students
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@example.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
