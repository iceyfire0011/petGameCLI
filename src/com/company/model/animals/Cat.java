package com.company.model.animals;

import com.company.enums.FoodType;
import com.company.model.foods.Food;

public class Cat extends Animal{
    public Cat(){
        this.setAnimalPrice(200);
        this.getFoodHabit().add(FoodType.FISH);
        this.getFoodHabit().add(FoodType.MEATS);
    }

    @Override
    public double feed( Food food){
        this.setHealthStatus(this.getHealthStatus() + this.getHealthStatus() * 0.1);
        return 0.25;
    }
}
