package com.dilawar.project.com.dilawar.project.repository.mysql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dilawar.project.com.dilawar.project.model.StudentModel;
import com.dilawar.project.com.dilawar.project.repository.StudentRepository;

public class StudentMysqlTest {

	    private Session session;
	    private StudentRepository repository;

	    @Before
	    public void setup() {
	        session = DatabaseClient.getCurrentSessionFromConfig().getSessionFactory().openSession();
	        repository = new StudentDbRepository(session);
	    }

	    @After
	    public void tearDown() {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }

	    @Test
	    public void insertStudentIntoDatabase() {
	        // Arrange
	        StudentModel student = new StudentModel(20l, "John Doe", "Computer Science");

	        // Act
	        student = repository.save(student);

	        // Assert
	        System.out.println(student);
	        assertThat(repository.findAll()).containsExactly(student);
	    }

	    @Test
	    public void updateStudentInDatabase() {
	        // Arrange
	        StudentModel student = new StudentModel(20l, "John Doe", "Computer Science");
	        StudentModel savedStudent = repository.save(student);

	        // Act
	        savedStudent.setStudentName("Updated Name");
	        StudentModel updatedStudent = repository.update(savedStudent);

	        // Assert
	        StudentModel fetchedStudent = repository.findById(updatedStudent.getStudentId());
	        assertThat(fetchedStudent.getStudentName()).isEqualTo("Updated Name");
	    }

	    @Test
	    public void deleteStudentFromDatabase() {
	        // Arrange
	        StudentModel student = new StudentModel(20l, "John Doe", "Computer Science");
	        repository.save(student);

	        // Act
	        repository.delete(student);

	        // Assert
	        assertThat(repository.findAll()).isEmpty();
	    }
	    
	    
	}
	  
