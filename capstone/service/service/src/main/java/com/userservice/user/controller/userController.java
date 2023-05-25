package com.userservice.user.controller;

import com.userservice.user.Service.UserService;
import com.userservice.user.ServiceImpl.UserServiceImpl;
import com.userservice.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {
//    @Autowired
//    UserService userService;
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/api/adduser")
    public String addUser(@RequestBody User user){
        System.out.println("asdd");
        return userService.addUser(user);
    }
//    @PutMapping("/api/buynow")
//    public String BuyNow(@RequestBody int id){
//        return userService.BuyNow(id);
//    }

    @PostMapping("/api/addmoney/{amount}/{userId}")
    public String AddMoney(@PathVariable("amount") int amount,@PathVariable("userId") int userId){
        return userService.AddMoney(amount,userId);
    }
    @GetMapping("/api/getbalance")
    public float findbal(@RequestBody int user_id){
        return userService.findbalance(user_id);
    }
}
