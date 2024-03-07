package com.bookstore.Service;


import java.util.List;

import com.bookstore.Model.Entity.Order;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

public interface IOrderService {


  List<Order> getAllOrder();
}
