package com.dilawar.project.com.dilawar.project.repository;

import java.util.List;

import com.dilawar.project.com.dilawar.project.model.BookAllocationModel;

public interface AllocationRepository {

	public List<BookAllocationModel> findAll();

	public BookAllocationModel assignOrRelease(BookAllocationModel model);

}
