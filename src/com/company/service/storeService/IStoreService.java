package com.company.service.storeService;

import com.company.model.animals.Animal;
import com.company.model.foods.Food;
import com.company.model.players.Player;

public interface IStoreService{
    void buyAnimal(Player player, Animal animal);

    void sellAnimal(Player player, int serial);

    void buyFood(Player player, int foodSerial, int amount);

    void sellFood(Player player, int serial, int amount);

}
