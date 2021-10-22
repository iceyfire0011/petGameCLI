package com.company.model.animals;

import com.company.enums.FoodType;
import com.company.enums.Gender;
import com.company.model.foods.Food;

import java.security.SecureRandom;
import java.util.LinkedList;

public abstract class Animal {
    private double animalPrice;
    private String animalName;
    private Gender sex;
    private double healthStatus = 100;
    private boolean MateStatus = false;
    private LinkedList<FoodType> foodHabit;

    public Animal(){
        this.setRandomName();
    }

    //<Getter and Setter>
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

    public LinkedList<FoodType> getFoodHabit(){
        return foodHabit;
    }

    public void setFoodHabit(LinkedList<FoodType> foodHabit){
        this.foodHabit = foodHabit;
    }
    //<Getter and Setter/>

    //<Abstraction>
    public abstract double feed(double amountOfFoodInKg, Food food);
    //<Abstraction/>

    //<Helper>
    public void setRandomName() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        int len = 5;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        setAnimalName(sb.toString());
    }

    boolean feedValidation(Food food){
        return this.getFoodHabit().contains(food);
    }
    //<Helper/>

}
