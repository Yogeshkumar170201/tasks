package com.tasks.order.producer.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Represent Order
 */
@Data
@Getter
@Setter
@ToString
public class Order {
    private String name;
    private Long timeOfPreparation;
    private String type;
}
