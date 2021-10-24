package com.company.model.players;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.company.enums.FoodType;
import com.company.model.animals.Animal;
import com.company.model.foods.Food;

public class Player{
    private int id;
    private String name;
    private double balance;
    private LinkedHashMap<Integer,Animal> animals;
    private LinkedHashMap<Integer,Food> foodWallets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public LinkedHashMap<Integer, Animal> getAnimals(){
        return animals;
    }

    public void setAnimals(LinkedHashMap<Integer, Animal> animals){
        this.animals = animals;
    }

    public LinkedHashMap<Integer, Food> getFoodWallets(){
        return foodWallets;
    }

    public void setFoodWallets(LinkedHashMap<Integer, Food> foodWallets){
        this.foodWallets = foodWallets;
    }

    @Override
    public String toString() {
        return "Player [balance=" + balance + ", id=" + id + ", name=" + name + "]";
    }

}
