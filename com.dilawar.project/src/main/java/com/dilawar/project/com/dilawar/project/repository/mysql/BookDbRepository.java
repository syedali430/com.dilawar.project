package com.dilawar.project.com.dilawar.project.repository.mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dilawar.project.com.dilawar.project.model.BookModel;
import com.dilawar.project.com.dilawar.project.repository.BookRepository;

public class BookDbRepository implements BookRepository {
	private Session session;

	public BookDbRepository(Session session) {
		super();
		this.session = session;
	}

	@Override
	public List<BookModel> findAll() {
		List<BookModel> books = null;
		try {
			books = session.createQuery("FROM BookModel", BookModel.class).list();
			return books;
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.toString());
		}
		return books;
	}

	@Override
	public BookModel findById(Long bookId) {
		return session.get(BookModel.class, bookId);
	}

	@Override
	public BookModel save(BookModel book) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
			return book;
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
				throw new IllegalArgumentException("Data not inserted in the database");
			}

		}
		return null;
	}

	@Override
	public BookModel update(BookModel book) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();
			return book;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new IllegalArgumentException("Data not updated in the database", e);
		}
	}

	
    @Override
    public void delete(BookModel book) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new IllegalArgumentException("Data not deleted in the database", e);
        }
    }

}
