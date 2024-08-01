package com.bootproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootproject.entities.Book;
import com.bootproject.service.BookService;


@RestController
public class BookController {
	@Autowired
	private BookService bookservice;
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> list = bookservice.getAllBooks();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
	else {
		return ResponseEntity.of(Optional.of(list));
		}
	}
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id)
	{
		Book book =  bookservice.getBookById(id);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(book));
		}
	 
	}
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b=null;
				try{
					b=this.bookservice.addBooks(book);
					return ResponseEntity.status(HttpStatus.CREATED).build();
				}
				catch(Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			 
				}
		
	}
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		 try{
			 this.bookservice.deleteBook(id);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
		
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable int id)
	{
		try{
			this.bookservice.updateBook(book,id);
			 return ResponseEntity.ok().body(book);
		}
		catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	 
		 
		 
	 
	}
				
    	
}
