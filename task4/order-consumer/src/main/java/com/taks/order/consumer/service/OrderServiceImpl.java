package com.taks.order.consumer.service;

import com.taks.order.consumer.dao.OrderDao;
import com.taks.order.consumer.dto.OrderDetails;
import com.taks.order.consumer.exception.InvalidOrderException;
import com.taks.order.consumer.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Order Service Implementation
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    /**
     * @param orderDetails
     * Add order produced by kafka-producer in database
     * @return Order
     */
    @Override
    public Orders saveOrder(OrderDetails orderDetails) throws InvalidOrderException {

        if(orderDetails==null){
            throw new InvalidOrderException("Invalid Order", HttpStatus.BAD_REQUEST);
        }
        if(orderDetails.getName()==null || orderDetails.getName().isEmpty() || !orderDetails.getName().matches("^[a-zA-Z\\s]+$")){
            throw new InvalidOrderException("Name of order is not valid", HttpStatus.BAD_REQUEST);
        }
        if(orderDetails.getTimeOfPreparation()<=0){
            throw new InvalidOrderException("Time of preparation should be positive", HttpStatus.BAD_REQUEST);
        }
        if(orderDetails.getType()==null || orderDetails.getType().isEmpty() || !orderDetails.getType().matches("^[a-zA-Z\\s]+$")){
            throw new InvalidOrderException("Type of order is not valid", HttpStatus.BAD_REQUEST);
        }


        Orders order = new Orders();

        order.setName(orderDetails.getName());
        order.setTimeOfPreparation(orderDetails.getTimeOfPreparation());
        order.setType(orderDetails.getType());
        order.setDate(new Date());
        order.setStatus("In Preparation");

        orderDao.save(order);
        return order;
    }

    /**
     * @return List of Orders
     */
    @Override
    public List<Orders> getAllOrders() {
        return orderDao.findAll();
    }

    /**
     * @param name
     * Update Status of Order By Name
     * @return Updated Order
     */
    @Override
    public Orders updateStatusOfOrderByName(String name) throws InvalidOrderException {
        Orders order = orderDao.findByName(name);
        if (order==null){
            throw new InvalidOrderException("Order not found", HttpStatus.BAD_REQUEST);
        }
        order.setStatus("Prepared");
        orderDao.save(order);
        return order;
    }

    /**
     * @return List of prepared orders
     */
    @Override
    public List<Orders> getPreparedOrders() {
        return orderDao.getPreparedOrders();
    }

    /**
     * @return List of order in preparation
     */
    @Override
    public List<Orders> getInPreparedOrders() {
        return orderDao.getInPreparedOrders();
    }

}
