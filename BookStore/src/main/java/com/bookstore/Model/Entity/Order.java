package com.bookstore.Model.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

import com.bookstore.base.dto.BaseDto;
/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */
@Data
@Entity
@Table(schema = "book", name = "order")
public class Order extends BaseDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "book_name_id")
  private Integer bookNameId;
  @Column(name = "book_name")
  private String bookName;
  @Column(name = "book_size")
  private Integer bookSize;
  @Column(name = "price")
  private Integer price;
  @Column(name = "kayit_zamani")
  private LocalDateTime recordingTime;

}
