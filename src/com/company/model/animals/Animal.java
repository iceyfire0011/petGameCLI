package com.company.model.animals;

import com.company.PropertyConstant;
import com.company.enums.FoodType;
import com.company.enums.Gender;
import com.company.model.foods.Food;

import java.security.SecureRandom;
import java.util.LinkedList;

public abstract class Animal {
    private double animalPrice;
    private String animalName;
    private Gender sex;
    private double healthStatus = PropertyConstant.MAX_HEALTH_STATUS;
    private boolean MateStatus = false;
    private LinkedList<FoodType> foodHabit;

    public Animal(){
        this.setRandomName();
        this.setFoodHabit(new LinkedList());
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

    public boolean isMateStatus(){
        return MateStatus;
    }

    public void setMateStatus(boolean mateStatus){
        MateStatus = mateStatus;
    }

    public LinkedList<FoodType> getFoodHabit(){
        return foodHabit;
    }

    public void setFoodHabit(LinkedList<FoodType> foodHabit){
        this.foodHabit = foodHabit;
    }
    //<Getter and Setter/>

    //<Abstraction>
    public abstract double feed(Food food);
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

    public boolean foodHabitValidation(Food food){
        return this.getFoodHabit().contains(food);
    }
    //<Helper/>

}
