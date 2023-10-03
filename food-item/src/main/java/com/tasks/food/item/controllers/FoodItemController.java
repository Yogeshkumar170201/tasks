package com.tasks.food.item.controllers;

import com.tasks.food.item.models.FoodItem;
import com.tasks.food.item.repository.FoodItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class FoodItemController {

    @Autowired
    FoodItemRepository foodItemRepository;

    @PostMapping("/addItem")
    public int addItem(@RequestBody FoodItem foodItem){
        log.trace("This is a TRACE log");
        log.debug("This is a DEBUG log");
        log.info("This is an INFO log");
        log.error("This is an ERROR log");
        log.warn("This is an warn log");
        log.fatal("This is an fatal log");
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
