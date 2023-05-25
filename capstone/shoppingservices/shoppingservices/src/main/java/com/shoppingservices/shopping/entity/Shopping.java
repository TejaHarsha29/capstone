package com.shoppingservices.shopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Shopping")
public class Shopping {
    @Id
    @GeneratedValue(
            generator = "shopid-sequence"
    )
    @GenericGenerator(
            name = "shopid-sequence",
            parameters =@org.hibernate.annotations.Parameter(name="prefix",value="shop"),
            strategy = "com.shoppingservices.shopping.Idgenerator.ShopIdGenerator"

    )
    private String ShoppingId;
    @Column(name = "ShopProducts")
    private String ShopProducts;
    @Column(name = "Availability")
    private int Availability;
    @Column(name = "price")
    private float price;
}
