package com.company.model.animals;

public class Elephant extends Animal {

    public Elephant() {
        this.setAnimalPrice(10000);
    }

    @Override
    public double feed(double amountOfFoodInKg) {
        if (this.getHealthStatus() < 100) {
            this.setHealthStatus(this.getHealthStatus() + this.getHealthStatus() * 0.1);
            return 100 * amountOfFoodInKg;
        }
        return 0;
    }


}
