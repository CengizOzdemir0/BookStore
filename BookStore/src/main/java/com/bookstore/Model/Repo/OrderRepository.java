package com.bookstore.Model.Repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bookstore.Model.Entity.Order;
/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {



  List<Order> findAll();
}
