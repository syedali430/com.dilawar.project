package com.dilawar.project.com.dilawar.project.repository.mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dilawar.project.com.dilawar.project.model.BookAllocationModel;
import com.dilawar.project.com.dilawar.project.model.BookModel;
import com.dilawar.project.com.dilawar.project.repository.AllocationRepository;

public class AllocationDbRepository implements AllocationRepository {
	private Session session;

	public AllocationDbRepository(Session session) {
		super();
		this.session = session;
	}

	@Override
	public List<BookAllocationModel> findAll() {
		List<BookAllocationModel> allocations = null;
		try {
			allocations = session.createQuery("FROM BookAllocationModel", BookAllocationModel.class).list();
			return allocations;
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.toString());
		}
		return allocations;
	}

	@Override
	public BookAllocationModel assignOrRelease(BookAllocationModel model) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(model);
			transaction.commit();
			return model;
		} catch (Exception e) {
			System.out.println(e.toString());
			if (transaction != null) {
				transaction.rollback();
				throw new IllegalArgumentException("Data not inserted in the database");
			}

		}
		return null;
	}
}
