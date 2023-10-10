package com.taks.order.consumer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

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
    @NotNull(message = "Name can't be Null")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    private int timeOfPreparation;
    private String type;
    private Date date;
}
