package com.company.model.animals;

import com.company.enums.FoodType;
import com.company.model.foods.Food;

public class Guppy extends Animal{
    public Guppy(){
        this.setAnimalPrice(15);
        this.getFoodHabit().add(FoodType.MANNA);
        this.getFoodHabit().add(FoodType.GRAINS);
    }

    @Override
    public double feedUnit(){
        return 0.01;
    }
}
