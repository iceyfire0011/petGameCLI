package com.company.service.storeService;

import com.company.model.animals.Animal;
import com.company.model.foods.Food;
import com.company.model.players.Player;

import java.util.LinkedHashMap;

public class StoreService implements IStoreService{

    //<Animal Transaction>
    @Override
    public void buyAnimal(Player player, Animal animal){
        if(player.getBalance() >= animal.getAnimalPrice()){
            player.getAnimals().put(player.getAnimals().size() + 1, animal);
            player.setBalance(player.getBalance() - animal.getAnimalPrice());
        }
    }

    @Override
    public void sellAnimal(Player player, int serial){
        var animal = player.getAnimals().get(serial);
        if(animal.isMateStatus()){
            System.out.println("This animal is busy on mate. You cannot sell it in this turn.");
            return;
        }
        player.getAnimals().remove(serial);
        player.setBalance(player.getBalance() + ((animal.getHealthStatus() / 100) * animal.getAnimalPrice()));
    }

    @Override
    public void sellAllAnimalByPlayer(Player player){
        for(var animalKey : player.getAnimals().keySet()){
            sellAnimal(player, animalKey);
        }
    }
    //<Animal Transaction/>

    //<Food Transaction>
    @Override
    public void buyFood(Player player, int serial, int amount){
        var food = player.getFoodWallets().get(serial);
        if(player.getBalance() < (food.getFoodPrice() * amount)){
            System.out.println("Insufficient balance. Please try again.");
            return;
        }
        player.getFoodWallets().get(serial).setFoodAmount(food.getFoodAmount() + amount);
        player.setBalance(player.getBalance() - (food.getFoodPrice() * amount));
    }

    @Override
    public void sellFood(Player player, int serial, double amount){
        if(serial < 0 && player.getFoodWallets().size() < serial){
            System.out.println("Invalid serial. Please input a valid serial");
            return;
        }
        var food = player.getFoodWallets().get(serial);
        if(food.getFoodAmount() < amount){
            System.out.println("Insufficient food in wallet. Please try again.");
            return;
        }
        player.getFoodWallets().get(serial).setFoodAmount(food.getFoodAmount() - amount);
        player.setBalance(player.getBalance() + (food.getFoodPrice() * amount));
    }

    @Override
    public void sellAllFoodByPlayer(Player player){
        for(var foodKey : player.getFoodWallets().keySet()){
            sellFood(player, foodKey, player.getFoodWallets().get(foodKey).getFoodAmount());
        }
    }
    //<Food Transaction/>

}
