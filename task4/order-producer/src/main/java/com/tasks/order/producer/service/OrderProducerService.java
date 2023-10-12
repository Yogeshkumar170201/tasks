package com.tasks.order.producer.service;

import com.tasks.order.producer.constants.AppConstants;
import com.tasks.order.producer.dto.Order;
import com.tasks.order.producer.exception.InvalidOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *  Order Producer Service Produce order
 */
@Service
public class OrderProducerService {


    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;


    /**
     * @param order
     * this method produces order
     * @throws InvalidOrderException
     */
    public void produceOrder(Order order) throws InvalidOrderException {
        if(order==null){
            throw new InvalidOrderException("Invalid Order", HttpStatus.BAD_REQUEST);
        }
        if(order.getName()==null || order.getName().isEmpty() || !order.getName().matches("^[a-zA-Z\\s]+$")){
            throw new InvalidOrderException("Name of order is not valid", HttpStatus.BAD_REQUEST);
        }
        if(order.getTimeOfPreparation()<=0){
            throw new InvalidOrderException("Time of preparation should be positive", HttpStatus.BAD_REQUEST);
        }
        if(order.getType()==null || order.getType().isEmpty() || !order.getType().matches("^[a-zA-Z\\s]+$")){
            throw new InvalidOrderException("Type of order is not valid", HttpStatus.BAD_REQUEST);
        }
        kafkaTemplate.send(AppConstants.TOPIC_NAME, order);
    }
}
