package com.tasks.task2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FoodItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String name;
    @Column(
            nullable = false
    )
    private int timeOfPreparation;
    @Column(
            nullable = false
    )
    private String type;
}
