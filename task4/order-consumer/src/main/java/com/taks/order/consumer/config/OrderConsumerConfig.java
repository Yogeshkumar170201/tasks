package com.taks.order.consumer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taks.order.consumer.constants.AppConstants;
import com.taks.order.consumer.dto.OrderDetails;
import com.taks.order.consumer.exception.InvalidOrderException;
import com.taks.order.consumer.model.Orders;
import com.taks.order.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

/**
 * Kafka Consumer for order
 * Converting JsonString into Java Object
 * Adding order in database
 */
@Configuration
@RestControllerAdvice
public class OrderConsumerConfig {

    @Autowired
    private OrderService orderService;


    /**
     * @param value
     * Convert JsonString of Order into Java Object
     * Add order into database by calling Order Service
     * @return ResponseEntity of Map<String,String>
     */
    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    @ExceptionHandler({InvalidOrderException.class, JsonProcessingException.class})
    public ResponseEntity<Map<String, String>> getOrder(String value) {

        Map<String, String> res = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();

        OrderDetails orderDetails = null;
        try {
            orderDetails = objectMapper.readValue(value, OrderDetails.class);
            Orders orders = orderService.saveOrder(orderDetails);
            res.put("message", "Order Added in Database Successfully");
            res.put("httpStatus", String.valueOf(HttpStatus.CREATED));
            return ResponseEntity.ok(res);
        }catch (InvalidOrderException e){
            res.put("message", e.getMessage());
            res.put("httpStatus", String.valueOf(HttpStatus.BAD_REQUEST));
            return ResponseEntity.badRequest().body(res);
        }  catch (JsonProcessingException e) {
            res.put("message", e.getMessage());
            res.put("httpStatus", String.valueOf(HttpStatus.BAD_REQUEST));
            return ResponseEntity.badRequest().body(res);
        }

    }

}
