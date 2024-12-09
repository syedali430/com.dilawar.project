package com.dilawar.project.com.dilawar.project.repository.mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dilawar.project.com.dilawar.project.model.StudentModel;
import com.dilawar.project.com.dilawar.project.repository.StudentRepository;

public class StudentDbRepository implements StudentRepository {
	 private Session session;
	
	public StudentDbRepository(Session session) {
        this.session = session;
    }
	
	 @Override
	    public List<StudentModel> findAll() {
	        Transaction transaction = null;
	        List<StudentModel> students = null;
	        try {
	            transaction = session.beginTransaction();
	            students = session.createQuery("FROM StudentModel", StudentModel.class).list();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	        return students;
	    }

	    @Override
	    public StudentModel findById(Long studentId) {
	        Transaction transaction = null;
	        StudentModel student = null;
	        try {
	            transaction = session.beginTransaction();
	            student = session.get(StudentModel.class, studentId);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	        return student;
	    }

	    @Override
	    public StudentModel save(StudentModel student) {
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.save(student);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	        return student;
	    }

	    @Override
	    public StudentModel update(StudentModel student) {
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.update(student);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	        return student;
	    }

	    @Override
	    public void delete(StudentModel student) {
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.delete(student);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	    }
	}

