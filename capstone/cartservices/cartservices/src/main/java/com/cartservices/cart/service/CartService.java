package com.cartservices.cart.service;

import com.cartservices.cart.entity.Cart;

import java.util.List;

public interface CartService {
    public String addtocart(Cart cartitem);

    float BillAmount(int user_id);

    //    public String DeleteCartItem(String ProductId);
    public String DeleteCart();
    public String DeleteUsingId(Cart cartitem);
    public String Buynow(int user_id);


}
