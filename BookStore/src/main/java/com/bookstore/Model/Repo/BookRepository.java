package com.bookstore.Model.Repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bookstore.Model.Entity.Book;
/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

  List<Book> findAll();
}
