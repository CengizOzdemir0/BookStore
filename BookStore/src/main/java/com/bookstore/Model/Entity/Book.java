package com.bookstore.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = "book", name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "book_name")
  private String bookName;

  @Column(name = "book_size")
  private Integer bookSize;
  @Column(name = "price")
  private Integer price;
  @Column(name = "kayit_zamani")
  private LocalDateTime recordingTime;


}
