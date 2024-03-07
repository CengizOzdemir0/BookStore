package com.bookstore.Model.Repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bookstore.Model.Entity.Order;


public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {



  List<Order> findAll();
}
