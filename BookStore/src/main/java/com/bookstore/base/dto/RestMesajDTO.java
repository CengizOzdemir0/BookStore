package com.bookstore.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestMesajDTO implements Serializable {

  private String kodu;
  private String mesaj;

}
