package com.company.model.animals;

public class Elephant extends Animal{

    public Elephant(){
        this.setAnimalPrice(100);
    }

    @Override
    public double feed(double amountOfFoodInKg){
        return 10*amountOfFoodInKg;
    }

    
}
