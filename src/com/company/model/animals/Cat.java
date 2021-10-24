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
    public double feedUnit(){
        return 0.25;
    }
}
