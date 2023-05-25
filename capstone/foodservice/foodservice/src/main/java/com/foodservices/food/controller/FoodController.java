package com.foodservices.food.controller;


import com.foodservices.food.repository.FoodRepository;
import com.foodservices.food.entity.Food;
import com.foodservices.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@ComponentScan
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;
    @Autowired
    FoodRepository foodRepository;

    @PostMapping("/Food")
    public ResponseEntity<Food> saveFood(@RequestBody Food food){
        return new ResponseEntity<>(foodRepository.save(food), HttpStatus.CREATED);
    }
}
