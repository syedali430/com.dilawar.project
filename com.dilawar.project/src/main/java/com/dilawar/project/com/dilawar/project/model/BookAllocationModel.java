package com.dilawar.project.com.dilawar.project.model;

public class BookAllocationModel {
	private Long primaryId;
	private StudentModel student;
	private BookModel book;
	private String startDate;
	private String endDate;
	private String bookStatus;
	public BookAllocationModel(Long primaryId, StudentModel student, BookModel book, String startDate, String endDate,
			String bookStatus) {
		super();
		this.primaryId = primaryId;
		this.student = student;
		this.book = book;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bookStatus = bookStatus;
	}
	public BookAllocationModel(StudentModel student, BookModel book, String startDate, String endDate,
			String bookStatus) {
		super();
		this.student = student;
		this.book = book;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bookStatus = bookStatus;
	}
	public BookAllocationModel() {
		super();
	}
	public Long getPrimaryId() {
		return primaryId;
	}
	public void setPrimaryId(Long primaryId) {
		this.primaryId = primaryId;
	}
	public StudentModel getStudent() {
		return student;
	}
	public void setStudent(StudentModel student) {
		this.student = student;
	}
	public BookModel getBook() {
		return book;
	}
	public void setBook(BookModel book) {
		this.book = book;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	
	
}
