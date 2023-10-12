package com.taks.order.consumer.dao;

import com.taks.order.consumer.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Order Repository
 */
@Repository
public interface OrderDao extends JpaRepository<Orders, Long> {
}
