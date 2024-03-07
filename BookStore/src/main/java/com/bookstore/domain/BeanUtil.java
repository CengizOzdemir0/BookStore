package com.bookstore.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.context.ApplicationContext;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanUtil {

  private static ApplicationContext applicationContext;

  public static void setApplicationContext(ApplicationContext applicationContext) {
    BeanUtil.applicationContext = applicationContext;
  }

  public static <T> T getBean(Class<T> beanClass) {
    return applicationContext.getBean(beanClass);
  }
}
