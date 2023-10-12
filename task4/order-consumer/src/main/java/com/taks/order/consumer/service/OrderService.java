package com.taks.order.consumer.service;

import com.taks.order.consumer.dto.OrderDetails;
import com.taks.order.consumer.exception.InvalidOrderException;
import com.taks.order.consumer.model.Orders;

import java.util.List;

/**
 * Interface of Order Service
 */
public interface OrderService {
    /**
     * @param orderDetails
     * Save Order in database
     * @return Order
     */
    Orders saveOrder(OrderDetails orderDetails) throws InvalidOrderException;

    /**
     * @return all orders
     */
    List<Orders> getAllOrders();


    /**
     * @param name
     * Update Status of Order By Name
     * @return Upadted Order
     */
    Orders updateStatusOfOrderByName(String name) throws InvalidOrderException;

    /**
     * @return List of prepared orders
     */
    List<Orders> getPreparedOrders();

    /**
     * @return List of order in preparation
     */
    List<Orders> getInPreparedOrders();
}
