package com.cartservices.cart.controller;

import com.cartservices.cart.entity.Cart;
import com.cartservices.cart.serviceImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/cart")
public class cartController {
    @Autowired
    CartServiceImpl cartService;
    @PostMapping("/addToCart")
    public ResponseEntity<String> addtocart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.addtocart(cart));
    }
    @DeleteMapping("/delete")
    public String DeleteTheCart(){
        return cartService.DeleteCart();
    }
    @DeleteMapping("/deleteUsingId/")
    public String DeleteByUsingId(@RequestBody Cart cart){
        return cartService.DeleteUsingId(cart);
    }
    @PostMapping("/bill/{User_Id}")
    public float billamount(@PathVariable int User_Id){

        return cartService.BillAmount(User_Id);
    }
    @PostMapping("/buynow/{user_id}")
    public String buynow(@PathVariable int user_id){
        float billamount=cartService.BillAmount(user_id);
        return String.valueOf(billamount);

    }
}
