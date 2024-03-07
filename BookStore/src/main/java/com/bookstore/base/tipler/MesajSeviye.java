package com.bookstore.base.tipler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonFormat;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MesajSeviye {
  INFO(1, "info"),
  WARN(2, "warn"),
  ERROR(3, "error");

  private final int val;
  private final String valText;
}

