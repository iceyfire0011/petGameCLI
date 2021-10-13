package com.company.model.players;
import java.util.List;
import com.company.model.animals.Animal;
import com.company.model.foods.Food;

public class Player{
    private int id;
    private String name;
    private double balance;
    private List<Animal> animals;
    private List<Food> foods;

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

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Player [balance=" + balance + ", id=" + id + ", name=" + name + "]";
    }

}
