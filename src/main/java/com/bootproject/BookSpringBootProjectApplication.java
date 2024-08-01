package com.bootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bootproject.repository.BookRepository;

@SpringBootApplication
public class BookSpringBootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BookSpringBootProjectApplication.class, args);
		  BookRepository bookRepo =  context.getBean(BookRepository.class);
//		  Book book = new Book();
//		  book.setBook_id(2);
//		  book.setBook_name("c in depth");
//book.setBook_desc("this is book for c in dept	h");
//		  Book book1 = bookRepo.save(book);
//		  System.out.println(book1);
		  
//		  Optional<User> user2 = userRepo.findById(452);
//		  userRepo.deleteById(352);
//		  System.out.println(user2);
		  
		   
		
	}
	}


