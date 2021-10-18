package com.company.model.players;
import java.util.LinkedHashMap;
import java.util.List;
import com.company.model.animals.Animal;
import com.company.model.foods.Food;

public class Player{
    private int id;
    private String name;
    private double balance;
    private LinkedHashMap<Animal,Float> animals;
    private LinkedHashMap<Food, Float> foods;

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

    public LinkedHashMap<Animal, Float> getAnimals(){
        return animals;
    }

    public void setAnimals(LinkedHashMap<Animal, Float> animals){
        this.animals = animals;
    }

    public LinkedHashMap<Food, Float> getFoods(){
        return foods;
    }

    public void setFoods(LinkedHashMap<Food, Float> foods){
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Player [balance=" + balance + ", id=" + id + ", name=" + name + "]";
    }

}
