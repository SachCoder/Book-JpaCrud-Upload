package com.bootproject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

  private int book_id;
	private String book_name,book_desc;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book(int book_id, String book_name, String book_desc,Author author) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_desc = book_desc;
		this.author = author;
	}

public Book() {
	super();
}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_desc=" + book_desc + ", author="
				+ author + "]";
	}
  public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_desc() {
		return book_desc;
	}
	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}
	 
	}
  

