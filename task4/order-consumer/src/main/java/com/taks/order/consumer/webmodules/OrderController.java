package com.taks.order.consumer.webmodules;

import com.taks.order.consumer.exception.InvalidOrderException;
import com.taks.order.consumer.model.Orders;
import com.taks.order.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Order Rest Controller
 */
@RestController
@RequestMapping("/orders")
@RestControllerAdvice
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

    /**
     * @param name
     * Update Order Status By Name
     * @return ResponseEntity<Map<String, String>>
     */
    @PutMapping("/update/{name}")
    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<Map<String, String>> updateOrderStatusByName(@PathVariable("name") String name){

        Map<String, String> res = new HashMap<>();

        try {
            orderService.updateStatusOfOrderByName(name);
            res.put("message", "Order is prepared");
            res.put("httpStatus", String.valueOf(HttpStatus.OK));
            return ResponseEntity.ok(res);
        } catch (InvalidOrderException e) {
            res.put("message", e.getErrorMessage());
            res.put("httpStatus", String.valueOf(e.getHttpStatus()));
            return ResponseEntity.badRequest().body(res);
        }
    }

    /**
     * @return List of prepared orders
     */
    @GetMapping("/prepared")
    public List<Orders> getPreparedOrders(){
        return orderService.getPreparedOrders();
    }

    /**
     * @return List of order in preparation
     */
    @GetMapping("/in-preparation")
    public List<Orders> getInPreparedOrders(){
        return orderService.getInPreparedOrders();
    }
}
