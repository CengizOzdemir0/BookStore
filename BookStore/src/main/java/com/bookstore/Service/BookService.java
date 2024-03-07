package com.bookstore.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.Model.Entity.Book;
import com.bookstore.Model.Repo.BookRepository;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{

  private final BookRepository bookRepository;

  @Override
  public List<Book> getAllBook() {
    return (List<Book>) bookRepository.findAll();
  }


}
