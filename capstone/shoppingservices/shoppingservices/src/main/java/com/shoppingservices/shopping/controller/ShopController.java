package com.shoppingservices.shopping.controller;

import com.shoppingservices.shopping.entity.Shopping;
import com.shoppingservices.shopping.reopository.ShopRepository;
import com.shoppingservices.shopping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class ShopController {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ShopService shopService;
    @PostMapping("/api/shopping")
    public ResponseEntity<Shopping> saveShop(@RequestBody Shopping shopping){
        return new ResponseEntity<>(shopRepository.save(shopping), HttpStatus.CREATED);
    }
}
