package com.bookstore.base.tipler;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@Getter
@AllArgsConstructor
public enum Dil {
  TR(1, "tr", "TR", "tr-TR", "Türkçe"),
  EN(2, "en", "US", "en-US", "İngilizce"),
  AR(3, "ar", "SA", "ar-SA", "Arapça"),
  RU(4, "ru", "RU", "ru-RU", "Rusça"),
  DE(5, "de", "DE", "de-DE", "Almanca");

  private final int val;
  private final String kod;
  private final String ulke;
  private final String ulkeKodu;
  private final String adi;
}