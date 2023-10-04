package com.tasks.task3.controller;

import com.tasks.task3.model.Order;
import com.tasks.task3.service.OrderService;
import com.tasks.task3.utils.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private UtilFunctions utilFunctions;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;



//    @PostMapping("/order")
//    public void orderPlaced(@RequestBody Order order){
//        utilFunctions.ordered(order);
//        utilFunctions.prepared(order);
//        utilFunctions.delivered(order);
//    }

    @PostMapping("/order")
    public void orderPlace(@RequestBody Order order){
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(()->{
            System.out.println("Performing Task 1..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 2..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 3..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 4..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 5..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 6..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 7..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 8..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 9..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 10..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 11..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 12..... "+Thread.currentThread().getName());
        });
        tasks.add(()->{
            System.out.println("Performing Task 13..... "+Thread.currentThread().getName());
        });
        tasks.forEach((task)->{threadPoolTaskExecutor.execute(task);});
    }


    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

}
