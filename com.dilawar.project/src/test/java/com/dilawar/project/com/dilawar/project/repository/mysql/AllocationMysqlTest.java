package com.dilawar.project.com.dilawar.project.repository.mysql;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dilawar.project.com.dilawar.project.model.BookAllocationModel;
import com.dilawar.project.com.dilawar.project.model.BookModel;
import com.dilawar.project.com.dilawar.project.model.CategoryEnum;
import com.dilawar.project.com.dilawar.project.model.StudentModel;
import com.dilawar.project.com.dilawar.project.repository.AllocationRepository;
import com.dilawar.project.com.dilawar.project.repository.BookRepository;
import com.dilawar.project.com.dilawar.project.repository.StudentRepository;

public class AllocationMysqlTest {
	private Session session;
	private AllocationRepository allocationRepository;
	private BookRepository bookRepository;
	private StudentRepository studentRepository;

	@Before
	public void setup() {
		session = DatabaseClient.getCurrentSessionFromConfig().getSessionFactory().openSession();

		allocationRepository = new AllocationDbRepository(session);
		bookRepository = new BookDbRepository(session);
		studentRepository = new StudentDbRepository(session);

	}

	@After
	public void onTearDown() {
		session.close();
	}
	
	// Find all 

	@Test
	public void testAssignBook() {
		BookModel book = bookRepository.save(new BookModel("Abc book", "Ali", "Math"));
		StudentModel student = studentRepository.save(new StudentModel("Syed", "syed@gmail.com"));

		BookAllocationModel model = new BookAllocationModel(student, book, "12/12/24", "13/12/24", "ASSINGNED");
		model = allocationRepository.assignOrRelease(model);

		assertThat(allocationRepository.findAll()).containsExactly(model);

	}

}
