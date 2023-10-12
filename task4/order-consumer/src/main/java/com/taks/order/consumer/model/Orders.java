package com.taks.order.consumer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

/**
 * Model of Order that will be stored in database
 */
@Entity
@Data
@Table(
        name = "order_details"
)
public class Orders {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String name;
    private int timeOfPreparation;
    private String type;
    private Date date;
    private String status;
}
