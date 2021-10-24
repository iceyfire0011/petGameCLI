package com.company.model.animals;

import com.company.enums.FoodType;
import com.company.model.foods.Food;

public class Elephant extends Animal{

    public Elephant(){
        this.setAnimalPrice(10000);
        this.getFoodHabit().add(FoodType.GRAINS);
        this.getFoodHabit().add(FoodType.GRASSES);
    }

    @Override
    public double feedUnit(){
        return 100;
    }


}
