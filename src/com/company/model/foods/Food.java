package com.company.model.foods;

import com.company.enums.FoodType;

public class Food{
    private double foodPrice;
    private FoodType foodType;
    private double foodAmount;

    public double getFoodPrice(){
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice){
        this.foodPrice = foodPrice;
    }

    public FoodType getFoodType(){
        return foodType;
    }

    public void setFoodType(FoodType foodType){
        this.foodType = foodType;
    }

    public double getFoodAmount(){
        return foodAmount;
    }

    public void setFoodAmount(double foodAmount){
        this.foodAmount = foodAmount;
    }
}
