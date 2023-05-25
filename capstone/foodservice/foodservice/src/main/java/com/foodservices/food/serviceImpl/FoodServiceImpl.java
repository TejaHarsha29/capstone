package com.foodservices.food.serviceImpl;

//import com.app.cart.entity.Cart;
//import com.app.cart.repository.CartRepository;
//import com.app.cart.serviceImpl.CartServiceImpl;
import com.foodservices.food.repository.FoodRepository;
import com.foodservices.food.entity.Food;
import com.foodservices.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.foodservices.food.entity.Cart;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;
    RestTemplate restTemplate=new RestTemplate();

    @Override
    public String AddFoodToCart(Cart cartitem) {
        String url="http://localhost:8083/api/addToCart";
//        ResponseEntity<String> stringResponseEntity=restTemplate.postForObject(url,String);
        String id = cartitem.getProduct_id();
        Optional<Food> fooditem = foodRepository.findById(id);
        int quantity = fooditem.get().getNoOfPlates();
        if (cartitem.getQuantity() <= fooditem.get().getNoOfPlates()) {
            String stringResponseEntity=restTemplate.postForObject(url,cartitem,String.class);
//            cartservice.addtocart(cartitem);
            fooditem.get().setNoOfPlates(quantity);
            return "added to cart successfully";
        } else {
            return "item exceeds limit";
        }
    }
}
