package com.company.model.animals;

import com.company.enums.FoodType;
import com.company.model.foods.Food;

public class Mouse extends Animal{

    public Mouse(){
        this.setAnimalPrice(10);
        this.getFoodHabit().add(FoodType.GRAINS);
        this.getFoodHabit().add(FoodType.MEATS);
        this.getFoodHabit().add(FoodType.FISH);
    }

    @Override
    public double feedUnit(){
        return 0.1;
    }
}
