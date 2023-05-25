package com.foodservices.food.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private int User_Id;
    private String ProductName;
    private String Product_id;
    private float Price;
    private int quantity;
}
