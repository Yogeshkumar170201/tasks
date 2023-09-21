package com.tasks.task2.service;

import com.tasks.task2.model.FoodItem;
import com.tasks.task2.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemServiceImpl implements FoodItemService{

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public Long addFoodItem(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
        return foodItem.getId();
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @Override
    public Optional<FoodItem> getFoodItemById(Long id) throws Exception {
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);
        if (foodItem.isPresent()){
            return foodItem;
        }else{
            throw new Exception("No such Food Item Exists");
        }
    }
}
