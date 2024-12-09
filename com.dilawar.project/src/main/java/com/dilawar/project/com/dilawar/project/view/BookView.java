package com.dilawar.project.com.dilawar.project.view;

import java.util.List;

import com.dilawar.project.com.dilawar.project.model.BookModel;

public interface BookView {

	 void showAllBook(List<BookModel> Books);

	    
	    void BookAdded(BookModel book);

	   
	    void BookUpdate(BookModel Book);

	    
	    void BookRemoved(BookModel Book);

	   
	    void showError(String message, BookModel Book);

	   
	    void showErrorNotFound(String message, BookModel Book);
	
	
	
}
