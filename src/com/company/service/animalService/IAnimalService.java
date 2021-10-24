package com.company.service.animalService;

import com.company.model.animals.Animal;
import com.company.model.foods.Food;
import com.company.model.players.Player;

public interface IAnimalService{
    void changeHealth(Animal animal, float healthPointChange);

    void mating(Player player,int firstAnimalNumber, int secondAnimalNumber);

    Animal animalFactory(int animalOption);

    void chooseGender(Animal animal, int genderChoice);

    void animalDetailsListByPlayer(Player player);

    boolean isPlayerHasAnimal(Player player);

    void feedAnimalByPlayer(Player player, int animalSerial, int foodSerial, double amount);

}
