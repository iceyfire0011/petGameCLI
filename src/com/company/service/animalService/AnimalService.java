package com.company.service.animalService;

import com.company.constantManager.PropertyConstant;
import com.company.enums.Gender;
import com.company.model.animals.*;
import com.company.model.foods.Food;
import com.company.model.players.Player;
import com.company.service.presentation.IPresentationService;
import com.company.service.presentation.PresentationService;

import java.util.Scanner;

public class AnimalService implements IAnimalService{
    IPresentationService _presentationService;

    public AnimalService(){
        this._presentationService = new PresentationService();
    }

    @Override
    public void changeHealth(Animal animal, float healthPointChange){
        animal.setHealthStatus(animal.getHealthStatus() + healthPointChange);
    }

    @Override
    public void mating(Player player, int firstAnimalNumber, int secondAnimalNumber){
        var firstAnimal = player.getAnimals().get(firstAnimalNumber);
        var secondAnimal = player.getAnimals().get(secondAnimalNumber);
        if(mateValidation(firstAnimal, secondAnimal)){
            var childAnimal = firstAnimal;
            childAnimal.setRandomName();
            if(Math.random() > 0.5){
                childAnimal.setSex(secondAnimal.getSex());
            }
            player.getAnimals().put(player.getAnimals().size(), childAnimal);
        }
    }

    private boolean mateValidation(Animal firstAnimal, Animal secondAnimal){
        if(firstAnimal.isMateStatus()){
            System.out.println(firstAnimal.getAnimalName() + " is already in matting. Please select different animal.");
            return false;
        }
        if(secondAnimal.isMateStatus()){
            System.out.println(secondAnimal.getAnimalName() + " is already in matting. Please select different animal.");
            return false;
        }
        if(!firstAnimal.getClass().getName().equals(secondAnimal.getClass().getName())){
            System.out.println("Wrong species for mating. Please select same species");
            return false;
        }
        if(firstAnimal.getSex().equals(secondAnimal.getSex())){
            System.out.println("Please pair animals with different gender.");
            return false;
        }
        return true;
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
                int gender = sc.nextInt();
                chooseGender(animal, gender);
                sc.close();
        }
    }

    @Override
    public void animalDetailsListByPlayer(Player player){
        var data = new String[]{"Serial", "AnimalType", "AnimalName", "Gender", "HealthStatus", "MateStatus"};
        _presentationService.printAsTableRow(true, data);
        int length = data.length * (PropertyConstant.MAX_PRESENTATION_COLUMN_LENGTH + 1);
        for(var keyItem : player.getAnimals().keySet()){
            var animal = player.getAnimals().get(keyItem);
           data = new String[]{
                    keyItem.toString(),
                    animal.getClass().getSimpleName(),
                    animal.getAnimalName(),
                    animal.getSex().toString(),
                    animal.getHealthStatus() + "",
                    animal.isMateStatus() + ""};
            _presentationService.printAsTableRow(false, data);
        }
        _presentationService.printSeparator(length);
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
        var foodUnit = animal.feedUnit();
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
        System.out.println(animal.getAnimalName() + " has eaten " + eatenFood + " kg of " + food.getFoodType()
                                   + ". Now its current health is " + player.getAnimals().get(animalSerial).getHealthStatus()
                                   + ". Remaining " + amount + " of " + food.getFoodType() + " has return to food wallet of player " + player.getName());
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
        if(food.getFoodAmount() < amount){
            System.out.println("Invalid amount of food to feed. Please buy more food first.");
        }
    }
}
