package com.tasks.food.item.controllers;

import com.tasks.food.item.models.FoodItem;
import com.tasks.food.item.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodItemController {

    @Autowired
    FoodItemRepository foodItemRepository;

    @PostMapping("/addItem")
    public int addItem(@RequestBody FoodItem foodItem){
        foodItemRepository.addItem(foodItem);
        return foodItem.getId();
    }

    @GetMapping("/items")
    public List<FoodItem> getAllItems(){
        return foodItemRepository.getAllItems();
    }

    @GetMapping("/items/{id}")
    public FoodItem getItemById(@PathVariable("id") int id) throws Exception {
        return (FoodItem) foodItemRepository.getItemById(id);
    }
}
