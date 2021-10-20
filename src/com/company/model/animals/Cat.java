package com.company.model.animals;

public class Cat extends Animal{
    public Cat() {
        this.setAnimalPrice(200);
    }

    @Override
    public double feed(double amountOfFoodInKg) {
        if (this.getHealthStatus() < 100) {
            this.setHealthStatus(this.getHealthStatus() + this.getHealthStatus() * 0.1);
            return 0.25 * amountOfFoodInKg;
        }
        return 0;
    }
}
