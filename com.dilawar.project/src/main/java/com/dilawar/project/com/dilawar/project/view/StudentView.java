package com.dilawar.project.com.dilawar.project.view;

import java.util.List;

import com.dilawar.project.com.dilawar.project.model.StudentModel;

public interface StudentView {
	
	 void showAllStudents(List<StudentModel> students);

	    
	    void studentAdded(StudentModel student);

	   
	    void studentUpdate(StudentModel student);

	    
	    void studentRemoved(StudentModel student);

	   
	    void showError(String message, StudentModel student);

	   
	    void showErrorNotFound(String message, StudentModel student);


}
