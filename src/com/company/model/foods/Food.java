package com.company.model.foods;

import com.company.enums.FoodType;

public abstract class Food{
    private String foodName;
    private String foodPrice;
    private FoodType foodType;
    
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getFoodPrice() {
        return foodPrice;
    }
    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }
    public FoodType getFoodType() {
        return foodType;
    }
    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
    
}
