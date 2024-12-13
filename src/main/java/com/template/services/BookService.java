package com.template.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.template.entities.Book;
import com.template.repositories.library.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepo;
	
	public BookService(BookRepository repo) {
		this.bookRepo = repo;
	}
	
	public List<Book> getBooks(){
		return bookRepo.findAll();
	}
}
