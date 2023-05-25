package com.foodservices.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Food")
public class Food {
    @Id
    @GeneratedValue(
            generator = "foodid-sequence"
    )
    @GenericGenerator(
            name = "foodid-sequence",
            parameters =@org.hibernate.annotations.Parameter(name="prefix",value= "food"),
            strategy = "com.foodservices.food.Idgenerator.FoodIdGenerator"

    )
    private String FoodId;
    @Column(name = "fooditem")
    private String FoodItem;
    @Column(name="price")
    private float Price;
    @Column(name = "noofplates")
    private int NoOfPlates;

//    public String getFoodId() {
//        return FoodId;
//    }
//
//    public void setFoodId(String foodId) {
//        FoodId = foodId;
//    }
//
//    public String getFoodItem() {
//        return FoodItem;
//    }
//
//    public void setFoodItem(String foodItem) {
//        FoodItem = foodItem;
//    }
//
//    public int getPrice() {
//        return Price;
//    }
//
//    public void setPrice(int price) {
//        Price = price;
//    }
//
//    public int getNoOfPlates() {
//        return NoOfPlates;
//    }
//
//    public void setNoOfPlates(int noOfPlates) {
//        NoOfPlates = noOfPlates;
//    }
//
//    public Food(String foodId, String foodItem, int price, int noOfPlates) {
//        FoodId = foodId;
//        FoodItem = foodItem;
//        Price = price;
//        NoOfPlates = noOfPlates;
//    }
//
//    public Food() {
//    }

    @Override
    public String toString() {
        return "Food{" +
                "FoodId='" + FoodId + '\'' +
                ", FoodItem='" + FoodItem + '\'' +
                ", Price=" + Price +
                ", NoOfPlates=" + NoOfPlates +
                '}';
    }
}
