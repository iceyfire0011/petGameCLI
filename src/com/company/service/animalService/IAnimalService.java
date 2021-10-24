package com.company.service.animalService;

import com.company.model.animals.Animal;
import com.company.model.players.Player;

import java.util.Map;

public interface IAnimalService{
    void changeHealth(Animal animal, float healthPointChange);

    boolean validateNewAnimal(Map<Animal, Float> animals,Animal animal);

    Map<Animal, Float> notFullHealthAnimals(Map<Animal, Float> animals);

    Animal mating(Animal maleAnimal, Animal femaleAnimal, Animal childAnimal);

    Animal animalFactory(int animalOption);

    void chooseGender(Animal animal, int genderChoice);

    void animalDetailsListByPlayer(Player player);

    boolean isPlayerHasAnimal(Player player);

}
