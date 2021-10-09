package com.company.model.animals;

import com.company.enums.Gender;

public abstract class Animal{
    private double animalPrice;
    private String animalName;
    private Gender sex;
    private double healthStatus=100;

    //Getter and Setter
    public double getAnimalPrice(){
        return animalPrice;
    }

    public void setAnimalPrice(double animalPrice){
        this.animalPrice = animalPrice;
    }

    public String getAnimalName(){
        return animalName;
    }

    public void setAnimalName(String animalName){
        this.animalName = animalName;
    }

    public Gender getSex(){
        return sex;
    }

    public void setSex(Gender sex){
        this.sex = sex;
    }

    public double getHealthStatus(){
        return healthStatus;
    }

    public void setHealthStatus(double healthStatus){
        this.healthStatus = healthStatus;
    }
    //Getter and Setter

    public abstract double feed(double amountOfFoodInKg);
}
