package com.cartservices.cart.serviceImpl;

import com.cartservices.cart.entity.Cart;
import com.cartservices.cart.repository.CartRepository;
import com.cartservices.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    RestTemplate restTemplate=new RestTemplate();
    @Override
    public String addtocart(Cart cartitem) {
          cartRepository.save(cartitem);
          return "Added successfully";
    }

    @Override
    public float BillAmount(int user_id) {
        List<Cart> cartitems=cartRepository.findByUserId(user_id);
        float bill=0;
        for (int i=0;i<cartitems.size();i++)
        {
           bill=bill+(cartitems.get(i).getQuantity()*cartitems.get(i).getPriceperUnit());
        }
        return bill;
    }

    @Override
    public String DeleteCart() {
        cartRepository.deleteAll();
        return "Deleted cart successfully";
    }
    @Override
    public String DeleteUsingId(Cart cartitem) {
        cartRepository.delete(cartitem);
        return "Deletion of item successful";
    }

    @Override
    public String Buynow(int user_id) {
        float billamount=BillAmount(user_id);
        String url="http://localhost:8087/api/getbalance";
        float balance=restTemplate.getForObject(url,float.class);
        if(billamount>balance)
        {
            return "insufficient funds";
        }
        else
            return "purchase successful";
    }

//    @Override
//    public String DeleteCartItem(String ProductId) {
//        List<Cart> cart1=cartRepository.findByProductId(ProductId);
//
//        return "Cart with productId is deleted";
//    }

}
