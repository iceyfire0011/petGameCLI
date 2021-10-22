package com.company.service.StoreService;

import com.company.model.animals.Animal;
import com.company.model.foods.Food;
import com.company.model.players.Player;

public interface IStoreService {
    void buyAnimal(Player player, Animal animal);
    void sellAnimal(Player player, Animal animal);

    void buyFood(Player player, Food food, int amount);

}
