package com.bootproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int author_id;
	private String author_name;
	private String author_type;
	@OneToOne(mappedBy =  "author")
	@JsonBackReference
	private Book book;
	public Author(int author_id, String author_name, String author_type, Book book) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.author_type = author_type;
		this.book = book;
	}

	public Author() {
		super();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	 
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthor_type() {
		return author_type;
	}
	public void setAuthor_type(String author_type) {
		this.author_type = author_type;
	}
	
}
