package com.dilawar.project.com.dilawar.project.repository.mysql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dilawar.project.com.dilawar.project.model.BookModel;
import com.dilawar.project.com.dilawar.project.model.CategoryEnum;
import com.dilawar.project.com.dilawar.project.repository.BookRepository;

import org.hibernate.Session;

public class BookMysqlTest {
	private Session session;
	private BookRepository repository;

	@Before
	public void setup() {
		session = DatabaseClient.getCurrentSessionFromConfig().getSessionFactory().openSession();

		repository = new BookDbRepository(session);
	}

	@After
	public void onTearDown() {
		session.close();
	}

	@Test
	public void insertBookIntoDatabase() {

		BookModel book = new BookModel("AAA", "Ali", "Computer");
		book = repository.save(book);
		System.out.println(book);
		assertThat(repository.findAll()).containsExactly(book);

	}

	@Test
	public void updateBookInDatabase() {
		BookModel book = new BookModel("AAA", "Ali", "Computer");
		BookModel savedBook = repository.save(book);
		savedBook.setName("Updated Title");
		BookModel updatedNewBook = repository.update(savedBook);

		BookModel updatedBook = repository.findById(updatedNewBook.getBookId());
		assertThat(updatedBook.getName()).isEqualTo("Updated Title");
	}

	@Test
	public void deleteBookFromDatabase() {
		BookModel book = new BookModel("AAA", "Ali", "Computer");
		repository.save(book);

		repository.delete(book);

		assertThat(repository.findAll()).isEmpty();
	}

	/**
	 * ye test hain.
	 */

	/**
	 * Test findAll method when the repository is empty.
	 */
	@Test
	public void testFindAllMethodWhenEmpty() {
		assertThat(repository.findAll()).as("The repository should be empty initially").isEmpty();
	}

	/**
	 * Test findAll method when the repository has entries.
	 */
	@Test
	public void testFindAllMethodWhenNotEmpty() {
		// Setup
		BookModel book1 = new BookModel("Book Title 1", "Author 1", "Computer");
		BookModel book2 = new BookModel("Book Title 2", "Author 2", "Science");

		// Exercise
		book1 = repository.save(book1);
		book2 = repository.save(book2);

		// Verify
		assertThat(repository.findAll()).containsExactly(book1, book2);
	}

	/**
	 * Test findById method when the repository is empty.
	 */
	@Test
	public void testFindByIdMethodWhenEmpty() {
		// Verify that findById returns null when no book exists for the given ID
		assertThat(repository.findById(1L)).isNull();
	}

	/**
	 * Test findById method when passing a null ID, expecting an exception.
	 * 
	 * @Test public void testFindByIdMethodWhenException() { try { // Attempt to
	 *       find by null ID repository.findById(null); fail("Expected an exception
	 *       to be thrown"); } catch (Exception e) {
	 *       assertThat(e.getMessage()).isEqualTo("failed to get book by id."); } }
	 */

	/**
	 * Test findById method when the repository contains the book.
	 */
	@Test
	public void testFindByIdMethodWhenNotEmpty() {
		// Setup
		BookModel book = new BookModel("Book Title", "Author", "Computer");

		// Exercise
		book = repository.save(book);

		// Verify
		assertThat(repository.findById(book.getBookId())).isEqualTo(book);
	}

	/**
	 * Test save method to add a new book to the repository.
	 */
	@Test
	public void testSaveMethod() {
		// Setup
		BookModel book = new BookModel("New Book Title", "New Author", "Math");

		// Exercise
		BookModel savedBook = repository.save(book);

		// Verify
		assertThat(repository.findById(savedBook.getBookId())).isEqualTo(savedBook);
	}

	/**
	 * Test update method to modify an existing book's details.
	 */
	@Test
	public void testUpdateMethod() {
		// Setup
		BookModel book = new BookModel("Original Title", "Original Author", "Science");
		book = repository.save(book);

		// Exercise
		book.setName("Updated Title");
		BookModel updatedBook = repository.update(book);

		// Verify
		assertThat(repository.findById(updatedBook.getBookId()).getName()).isEqualTo("Updated Title");
	}

	/**
	 * Test delete method to remove a book from the repository.
	 */
	@Test
	public void testDeleteMethod() {
		// Setup
		BookModel book = new BookModel("Book to Delete", "Author", "Computer");
		book = repository.save(book);

		// Exercise
		repository.delete(book);

		// Verify
		assertThat(repository.findAll()).isEmpty();
	}

}
