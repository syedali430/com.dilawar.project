package com.dilawar.project.com.dilawar.project.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")

public class BookModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")

	private Long bookId;
	@Column(name = "book_name")

	private String name;
	@Column(name = "publisher")

	private String publisher;

	@Enumerated(EnumType.STRING)

	private String category;

	public BookModel(Long bookId, String name, String publisher, String category) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.publisher = publisher;
		this.category = category;
	}

	public BookModel(String name, String publisher, String category) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.category = category;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BookModel() {
		super();
	}

	public Long getBookId() {
		return bookId;
	}

	public String getName() {
		return name;
	}

	public String getPublisher() {
		return publisher;

	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, name, publisher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookModel other = (BookModel) obj;
		return category == other.category && Objects.equals(name, other.name)
				&& Objects.equals(publisher, other.publisher);
	}

	@Override
	public String toString() {
		return "BookModel [bookId=" + bookId + ", name=" + name + ", publisher=" + publisher + ", category=" + category
				+ "]";
	}

}