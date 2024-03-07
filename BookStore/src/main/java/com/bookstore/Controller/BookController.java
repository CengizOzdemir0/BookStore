package com.bookstore.Controller;

import lombok.RequiredArgsConstructor;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Model.Entity.Book;
import com.bookstore.Model.Entity.Order;
import com.bookstore.Service.IBookService;
import com.bookstore.Service.IOrderService;
import com.bookstore.base.tipler.HttpStatus;
import com.bookstore.domain.ResponseHelper;
import com.bookstore.domain.RestResponse;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

  private final IBookService bookService;
  private final IOrderService orderService;


 @GetMapping("/booklist")
 public ResponseEntity<RestResponse<Book>> getAllBook() {
   List<Book> books = bookService.getAllBook();
   RestResponse<Book> response = new RestResponse<>();
   response.setListData(books);
   response.setHttpStatus(HttpStatus.OK);
   return ResponseHelper.responseEntityFromResponse(response);
 }

 @GetMapping("/order")
  public ResponseEntity<RestResponse<Order>> getAllOrder() {
   List<Order> orders = orderService.getAllOrder();
   RestResponse<Order> response = new RestResponse<>();
   response.setListData(orders);
   response.setHttpStatus(HttpStatus.OK);
   return ResponseHelper.responseEntityFromResponse(response);
 }


}
