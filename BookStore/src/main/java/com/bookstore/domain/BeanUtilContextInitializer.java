package com.bookstore.domain;

import jakarta.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanUtilContextInitializer {

  private final ApplicationContext context;

  public BeanUtilContextInitializer(ApplicationContext context) {
    this.context = context;
  }

  @PostConstruct
  public void init() {
    BeanUtil.setApplicationContext(context);
  }
}