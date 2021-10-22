package com.company.service.StoreService;

import com.company.model.animals.Animal;
import com.company.model.foods.Food;
import com.company.model.players.Player;

public class StoreService implements IStoreService{

    //<Animal Transaction>
    @Override
    public void buyAnimal(Player player, Animal animal){
        if(player.getBalance() >= animal.getAnimalPrice()){
            player.getAnimals().add(animal);
            player.setBalance(player.getBalance() - animal.getAnimalPrice());
        }
    }

    @Override
    public void sellAnimal(Player player, Animal animal){
        player.getAnimals().remove(animal);
        player.setBalance(player.getBalance() + ((animal.getHealthStatus() / 100) * animal.getAnimalPrice()));
    }
    //<Animal Transaction/>

    //<Food Transaction>
    @Override
    public void buyFood(Player player, Food food, int amount){
        if(player.getBalance() < (food.getFoodPrice() * amount)){
            return;
        }
        for(var foodAmount : player.getFoodWallets().keySet()){
            if(foodAmount.equals(food.getFoodType())){
                player.getFoodWallets().replace(foodAmount, player.getFoodWallets().get(foodAmount) + amount);
            }
        }
    }
    //<Food Transaction/>
}
