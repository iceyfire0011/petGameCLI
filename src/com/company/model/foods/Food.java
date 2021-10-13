package com.company.model.foods;

public abstract class Food{
    private String foodName;
    private String foodPrice;
    
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
    
}
