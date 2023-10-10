package com.taks.order.consumer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taks.order.consumer.constants.AppConstants;
import com.taks.order.consumer.dto.OrderDetails;
import com.taks.order.consumer.model.Orders;
import com.taks.order.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class OrderConsumerConfig {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void getOrder(String value) {
        ObjectMapper objectMapper = new ObjectMapper();

        OrderDetails orderDetails = null;
        try {
            orderDetails = objectMapper.readValue(value, OrderDetails.class);
            Orders orders = orderService.saveOrder(orderDetails);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(orderDetails);
    }

}
