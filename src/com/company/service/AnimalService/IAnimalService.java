package com.company.service.AnimalService;

import com.company.model.animals.Animal;

import java.util.Map;

public interface IAnimalService{
    Map<Animal, Float> changeHealth(Animal animal, float currentHealthStatus, float healthPointChange);

    boolean validateNewAnimal(Map<Animal, Float> animals,Animal animal);

    Map<Animal, Float> notFullHealthAnimals(Map<Animal, Float> animals);
}
