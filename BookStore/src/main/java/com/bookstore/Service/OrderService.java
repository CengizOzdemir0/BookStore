package com.bookstore.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.Model.Entity.Order;
import com.bookstore.Model.Repo.OrderRepository;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

  private final OrderRepository orderRepository;

  @Override
  public List<Order> getAllOrder() {
    List<Order> orders = orderRepository.findAll();
    return orders;
  }

}
