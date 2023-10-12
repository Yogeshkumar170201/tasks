package com.taks.order.consumer.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO of Order
 */
@Data
@Getter
@Setter
@ToString
public class OrderDetails {
        private String name;
        private int timeOfPreparation;
        private String type;
}
