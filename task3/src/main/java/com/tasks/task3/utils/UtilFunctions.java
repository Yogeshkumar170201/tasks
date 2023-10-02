package com.tasks.task3.utils;

import com.tasks.task3.model.Order;
import com.tasks.task3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UtilFunctions {

    @Autowired
    private OrderService orderService;

    @Async
    public void ordered(Order order){
        try {
            orderService.saveOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Order No. "+ order.getId() +" is placed");
    }

    @Async
    public void prepared(Order order){
        try {
            Thread.sleep(order.getTimeOfPreparation()*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Order No. "+ order.getId() +" is prepared");
    }

    @Async
    public void delivered(Order order){
        try {
            Thread.sleep(order.getTimeOfPreparation()*2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Order No. "+ order.getId() +" is delivered");
    }

}
