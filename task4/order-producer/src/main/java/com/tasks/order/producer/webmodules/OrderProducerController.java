package com.tasks.order.producer.webmodules;

import com.tasks.order.producer.dto.Order;
import com.tasks.order.producer.exception.InvalidOrderException;
import com.tasks.order.producer.service.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Order producing controller
 */
@RestController
@RestControllerAdvice
public class OrderProducerController {

    @Autowired
    private OrderProducerService orderProducerService;

    /**
     * @param order
     * @return ResponseEntity of Map<String, String>
     */
    @PostMapping("/produce-order")
    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<Map<String, String>> orderProducer(@RequestBody Order order) {
        Map<String, String> res = new HashMap<>();
        try {
            orderProducerService.produceOrder(order);
            res.put("message", "Order Produced Successfully");
            res.put("HttpStatus", String.valueOf(HttpStatus.CREATED));
            return ResponseEntity.ok(res);
        } catch (InvalidOrderException e) {
            res.put("message", e.getErrorMessage());
            res.put("HttpStatus", String.valueOf(e.getHttpStatus()));
            return ResponseEntity.badRequest().body(res);
        }
    }

}
