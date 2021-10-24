package com.company.service.animalService;

import com.company.PropertyConstant;
import com.company.enums.Gender;
import com.company.model.animals.*;
import com.company.model.foods.Food;
import com.company.model.players.Player;

import java.util.Scanner;

public class AnimalService implements IAnimalService{
    @Override
    public void changeHealth(Animal animal, float healthPointChange){
        animal.setHealthStatus(animal.getHealthStatus() + healthPointChange);
    }

    @Override
    public Animal mating(Animal maleAnimal, Animal femaleAnimal, Animal childAnimal){
        childAnimal.setSex(femaleAnimal.getSex());
        if(Math.random() > 0.5){
            childAnimal.setSex(maleAnimal.getSex());
        }
        return childAnimal;
    }

    @Override
    public Animal animalFactory(int animalOption){
        Animal animal = null;
        switch(animalOption){
            case 0:
                break;
            case 1:
                animal = new Cat();
                break;
            case 2:
                animal = new Elephant();
                break;
            case 3:
                animal = new Guppy();
                break;
            case 4:
                animal = new Mouse();
                break;
            default:
                System.out.println("Wrong input! Please select an animal");
        }
        return animal;
    }

    public void chooseGender(Animal animal, int genderChoice){
        switch(genderChoice){
            case 1:
                animal.setSex(Gender.Male);
                break;
            case 2:
                animal.setSex(Gender.Female);
                break;
            default:
                System.out.println("Wrong input!. Please Choose gender again.");
                Scanner sc = new Scanner(System.in);
                chooseGender(animal, sc.nextInt());
                sc.close();
        }
    }

    @Override
    public void animalDetailsListByPlayer(Player player){
        System.out.println("Serial \t AnimalName \t Gender \t HealthStatus \t MateStatus");
        for(var keyItem : player.getAnimals().keySet()){
            var animal = player.getAnimals().get(keyItem);
            System.out.println(keyItem + " \t " + animal.getAnimalName() + " \t " + animal.getSex() + " \t " + animal.getHealthStatus() + " \t " + animal.isMateStatus());
        }
    }

    @Override
    public boolean isPlayerHasAnimal(Player player){
        if(player.getAnimals().size() < 1){
            System.out.println("You have not purchase any animal yet. Please buy one first.");
            return false;
        }
        return true;
    }

    @Override
    public void feedAnimalByPlayer(Player player, int animalSerial, int foodSerial, double amount){
        Animal animal = player.getAnimals().get(animalSerial);
        Food food = player.getFoodWallets().get(foodSerial);
        var missingHealth = 100 - animal.getHealthStatus();
        feedValidation(animal, food, amount);
        var foodUnit = animal.feed(food);
        var requiredFoodUnit = missingHealth / 10;
        int eatenFood = 0;
        for(int i = 0; i < requiredFoodUnit; i++){
            if(eatenFood > amount){
                break;
            }
            eatenFood += foodUnit;
            changeHealth(player.getAnimals().get(animalSerial), PropertyConstant.HEALTH_VARIATION);
        }
        player.getFoodWallets().get(foodSerial).setFoodAmount(food.getFoodAmount() - eatenFood);
        System.out.println(animal.getAnimalName() + " has eaten " + eatenFood + "kg of" + food.getFoodType()
                                   + ". Now its current health is " + player.getAnimals().get(animalSerial).getHealthStatus()
                                   + ". Remaining " + amount + "of " + food.getFoodType() + " has return to food wallet of player " + player.getName());
    }

    private void feedValidation(Animal animal, Food food, double amount){
        var missingHealth = 100 - animal.getHealthStatus();
        if(missingHealth < 1){
            System.out.println("This animal health is full. Please choose different animal");
            return;
        }
        if(!animal.foodHabitValidation(food)){
            System.out.println("This animal cannot eat " + food.getFoodType() + ". Please choose different food");
            return;
        }
        if(food.getFoodAmount()<amount){
            System.out.println("Invalid amount of food to feed. Please buy more food first.");
        }
    }
}
