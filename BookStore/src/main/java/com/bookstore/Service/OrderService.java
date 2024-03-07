package com.bookstore.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.Model.Entity.Order;
import com.bookstore.Model.Repo.OrderRepository;


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
