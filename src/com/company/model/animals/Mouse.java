package com.company.model.animals;

public class Mouse extends Animal {

    public Mouse() {
        this.setAnimalPrice(10);
    }

    @Override
    public double feed(double amountOfFoodInKg) {
        if (this.getHealthStatus() < 100) {
            this.setHealthStatus(this.getHealthStatus() + this.getHealthStatus() * 0.1);
            return 0.1 * amountOfFoodInKg;
        }
        return 0;
    }
}
