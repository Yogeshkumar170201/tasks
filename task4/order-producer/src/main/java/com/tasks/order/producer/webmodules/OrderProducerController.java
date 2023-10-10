package com.tasks.order.producer.webmodules;

import com.tasks.order.producer.dto.Order;
import com.tasks.order.producer.service.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class OrderProducerController {

    @Autowired
    private OrderProducerService orderProducerService;

    @PostMapping("/produce-order")
    public ResponseEntity<Map<String, String>> orderProducer(@RequestBody Order order){
        Map<String, String> res = new HashMap<>();
        try {
            for(int i=0;i<10000000;i++){
                orderProducerService.produceOrder(order);
                res.put("message", "Order Produced Successfully");
            }
        }catch (Exception e){
            res.put("message", e.getMessage());
        }
        return ResponseEntity.ok(res);
    }

}
