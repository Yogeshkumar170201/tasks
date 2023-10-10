package com.tasks.order.producer.service;

import com.tasks.order.producer.constants.AppConstants;
import com.tasks.order.producer.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void produceOrder(Order order) {
        kafkaTemplate.send(AppConstants.TOPIC_NAME, order);
    }
}
