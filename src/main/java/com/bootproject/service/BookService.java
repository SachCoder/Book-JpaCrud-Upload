package com.bootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootproject.entities.Book;
import com.bootproject.repository.BookRepository;
 
@Component
public class BookService {
//	private   static List<Book> list = new ArrayList<Book>();
	@Autowired
	private BookRepository bookRepository;
//	static {
//		
//		list.add(new Book(12,"c","c in depth"));
//		list.add(new Book(15,"c++","c++ in depth"));
//		list.add(new Book(120,"java","java in depth"));
//	}
	
	//return all book
	public List<Book> getAllBooks() {
//		list = this.bookRepository.findAll();
//		 Book book = new Book();
//		  book.setBook_id(3);
//		  book.setBook_name("c in depth");
//book.setBook_desc("this is book for c in dept	h");
//		  Book book1 = this.bookRepository.save(book);
//		  System.out.println(book1);
		 List<Book> list = bookRepository.findAll();
		 return list;
		
	}
	//return one books
	public Book getBookById(int id){
//		Book book = null;
//		try {
//			book = list.stream().filter(e->
//			e.getBook_id()==id).findFirst().get();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		Book book = bookRepository.findById(id);
		return book;
	}
	//add book
	public Book addBooks(Book b) {
//		try {
//			list.add(b);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		Book book = bookRepository.save(b);
	
		return book;
	}
	//delete book
	//return one books
		public void deleteBook(int id){
//			list = list.stream().filter(e-> e.getBook_id()!=id).collect(Collectors.toList());
			bookRepository.deleteById(id);
			  
			 
		}
		public void updateBook(Book book, int id) {
//			list = list.stream().map(b->{
//			 
//				if(b.getBook_id()==id)
//				{
//					 
//				b.setBook_name(book.getBook_name());
//				b.setBook_desc(book.getBook_desc());
//				}
//			 return b;
//				}).collect(Collectors.toList());
//			 
			
			book.setBook_id(id);
			bookRepository.save(book);
			}
		}
 
	

