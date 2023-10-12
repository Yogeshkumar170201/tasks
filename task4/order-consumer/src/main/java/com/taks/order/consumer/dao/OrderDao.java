package com.taks.order.consumer.dao;

import com.taks.order.consumer.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Order Repository
 */
@Repository
public interface OrderDao extends JpaRepository<Orders, Long> {
    /**
     * @param name
     * Find Order By Name from Database
     * @return Order
     */
    Orders findByName(String name);


    /**
     * @return List of Prepared Orders
     */
    @Query(nativeQuery = true, value = "SELECT * FROM order_details WHERE status = 'Prepared'")
    List<Orders> getPreparedOrders();

    /**
     * @return List of In preparation orders
     */
    @Query(nativeQuery = true, value = "SELECT * FROM order_details WHERE status = 'In Preparation'")
    List<Orders> getInPreparedOrders();
}
