package com.tasks.task2.controller;

import com.tasks.task2.model.FoodItem;
import com.tasks.task2.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/addItem")
    public Long addFoodItem(@RequestBody FoodItem foodItem){
        return foodItemService.addFoodItem(foodItem);
    }

    @GetMapping("/items")
    public List<FoodItem> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/items/{id}")
    public Optional<FoodItem> getFoodItemById(@PathVariable("id") Long id) throws Exception {
        return foodItemService.getFoodItemById(id);
    }
}
