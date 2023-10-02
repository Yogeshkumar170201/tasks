package com.tasks.task3.controller;

import com.tasks.task3.model.Order;
import com.tasks.task3.service.OrderService;
import com.tasks.task3.utils.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private UtilFunctions utilFunctions;

    @Autowired
    private OrderService orderService;



    @PostMapping("/order")
    public void orderPlaced(@RequestBody Order order){
        utilFunctions.ordered(order);
        utilFunctions.prepared(order);
        utilFunctions.delivered(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

}
