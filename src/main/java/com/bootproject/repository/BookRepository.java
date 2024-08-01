package com.bootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootproject.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
     public Book findById(int id);
}
