package com.tasks.task2.service;

import com.tasks.task2.model.FoodItem;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    Long addFoodItem(FoodItem foodItem);

    List<FoodItem> getAllFoodItems();

    Optional<FoodItem> getFoodItemById(Long id) throws Exception;
}
