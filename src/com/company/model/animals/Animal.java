package com.company.model.animals;

import com.company.enums.Gender;

import java.security.SecureRandom;

public abstract class Animal {
    private double animalPrice;
    private String animalName;
    private Gender sex;
    private double healthStatus = 100;

    //Getter and Setter
    public double getAnimalPrice() {
        return animalPrice;
    }

    public void setAnimalPrice(double animalPrice) {
        this.animalPrice = animalPrice;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public double getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(double healthStatus) {
        this.healthStatus = healthStatus;
    }
    //Getter and Setter

    public abstract double feed(double amountOfFoodInKg);

    public void setRandomName() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        int len = 5;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        this.animalName =  sb.toString();
    }

}
