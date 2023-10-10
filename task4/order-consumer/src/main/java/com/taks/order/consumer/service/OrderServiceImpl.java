package com.taks.order.consumer.service;

import com.taks.order.consumer.dao.OrderDao;
import com.taks.order.consumer.dto.OrderDetails;
import com.taks.order.consumer.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public Orders saveOrder(OrderDetails orderDetails) {
        Orders order = new Orders();
        order.setName(orderDetails.getName());
        order.setTimeOfPreparation(orderDetails.getTimeOfPreparation());
        order.setType(orderDetails.getType());
        order.setDate(new Date());
        orderDao.save(order);
        return order;
    }
}
