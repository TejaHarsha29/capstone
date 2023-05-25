package com.cinemaservices.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private int Id;
    private String ProductName;
    private String Product_id;
    private float Price;
    private int quantity;
}
