package com.dilawar.project.com.dilawar.project.repository;

import java.util.List;

import com.dilawar.project.com.dilawar.project.model.StudentModel;

public interface StudentRepository {
	
		
    
    public List<StudentModel> findAll();

    
    public StudentModel findById(Long studentId);

    
    public StudentModel save(StudentModel student);

   
    public StudentModel update(StudentModel student);

   
    public void delete(StudentModel student);

}
