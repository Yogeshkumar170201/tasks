package com.taks.order.consumer.webmodules;

import com.taks.order.consumer.model.Orders;
import com.taks.order.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Order Rest Controller
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @return List of Orders
     */
    @GetMapping
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }
}
