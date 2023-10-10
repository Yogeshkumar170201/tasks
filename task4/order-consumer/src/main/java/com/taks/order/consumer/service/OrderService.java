package com.taks.order.consumer.service;

import com.taks.order.consumer.dto.OrderDetails;
import com.taks.order.consumer.model.Orders;

public interface OrderService {
    Orders saveOrder(OrderDetails orderDetails);
}
