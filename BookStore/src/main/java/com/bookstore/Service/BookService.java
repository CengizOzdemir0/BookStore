package com.bookstore.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.Model.Entity.Book;
import com.bookstore.Model.Repo.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{

  private final BookRepository bookRepository;

  @Override
  public List<Book> getAllBook() {
    return (List<Book>) bookRepository.findAll();
  }


}
