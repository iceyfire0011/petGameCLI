package com.company.model.animals;

public class Guppy extends Animal{
    Guppy(){
        this.setAnimalPrice(15);
    }

    @Override
    public double feed(double amountOfFoodInKg) {
        if (this.getHealthStatus() < 100) {
            this.setHealthStatus(this.getHealthStatus() + this.getHealthStatus() * 0.1);
            return 0.01 * amountOfFoodInKg;
        }
        return 0;
    }
}
