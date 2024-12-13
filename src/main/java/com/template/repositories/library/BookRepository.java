package com.template.repositories.library;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
