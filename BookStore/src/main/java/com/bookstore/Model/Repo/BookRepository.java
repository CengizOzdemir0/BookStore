package com.bookstore.Model.Repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bookstore.Model.Entity.Book;


public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

  List<Book> findAll();
}
