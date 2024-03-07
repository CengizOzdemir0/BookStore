package com.bookstore.Model.Repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.Model.Entity.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

}
