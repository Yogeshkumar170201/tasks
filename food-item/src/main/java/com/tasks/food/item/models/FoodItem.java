package com.tasks.food.item.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class FoodItem {
    public static int id_counter = 0;
    private int id;
    private String name;
//    Time of preparation in minutes
    private int timeOfPreparation;
    private String type;

    public FoodItem(String name, int timeOfPreparation, String type){
//        log.info("Id is : {}", id_counter);
        id_counter+=1;
        this.id = id_counter;
        this.name = name;
        this.timeOfPreparation = timeOfPreparation;
        this.type = type;
    }
}
