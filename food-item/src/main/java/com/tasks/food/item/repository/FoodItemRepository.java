package com.tasks.food.item.repository;

import com.tasks.food.item.models.FoodItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class FoodItemRepository {

    List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem foodItem) {
        items.add(foodItem);
    }

    public List<FoodItem> getAllItems() {
        return (List<FoodItem>) items;
    }

    public FoodItem getItemById(int id) throws Exception {
        List<FoodItem> foodItem = items.stream().filter(item->item.getId()==id).collect(Collectors.toList());
        if(foodItem.size()>0){
            return foodItem.get(0);
        }else {
            throw new Exception("No such food item exists");
        }
    }

}
