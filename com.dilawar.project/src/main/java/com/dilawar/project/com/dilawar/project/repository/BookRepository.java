package com.dilawar.project.com.dilawar.project.repository;

import java.util.List;

import com.dilawar.project.com.dilawar.project.model.BookModel;


public interface BookRepository {


	 public List<BookModel> findAll();

	    
	    public BookModel findById(Long BookId);

	    
	    public BookModel save(BookModel Book);

	   
	    public BookModel update(BookModel book);

	   
	    public void delete(BookModel book);
	
}
