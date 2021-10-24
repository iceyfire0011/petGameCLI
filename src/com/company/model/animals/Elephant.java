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
    public double feed(Food food){
        this.setHealthStatus(this.getHealthStatus() + this.getHealthStatus() * 0.1);
        return 100;
    }


}
