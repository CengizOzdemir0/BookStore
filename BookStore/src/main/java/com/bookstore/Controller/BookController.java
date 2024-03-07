package com.bookstore.Controller;

import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Model.Entity.Book;
import com.bookstore.Service.IBookService;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

  private final IBookService bookService;

  @GetMapping()
  public ResponseEntity<List<Book>> getAllBook() {
    List<Book> books = bookService.getAllBook();
    return ResponseEntity.ok().body(books);
  }

}
