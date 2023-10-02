package com.tasks.task3.service;

import com.tasks.task3.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);

    List<Order> getOrders();
}
