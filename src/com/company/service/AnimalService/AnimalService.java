package com.company.service.AnimalService;

import com.company.model.animals.Animal;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalService implements IAnimalService{
    @Override
    public Map<Animal, Float> changeHealth(Animal animal, float currentHealthStatus, float healthPointChange){
        var animalHealthMap = new LinkedHashMap<Animal, Float>();
        animalHealthMap.put(animal, currentHealthStatus + healthPointChange);
        return animalHealthMap;
    }

    @Override
    public boolean validateNewAnimal(Map<Animal, Float> animals, Animal animal){
        for(var item : animals.keySet()){
            if(item.getAnimalName().equals(animal.getAnimalName())){
                return false;
            }
        }
        return true;
    }

    @Override
    public Map<Animal, Float> notFullHealthAnimals(Map<Animal, Float> animals){
        Map<Animal, Float> unhealthyAnimals = new LinkedHashMap<Animal, Float>();
        for(var animal : animals.entrySet()){
            if(animal.getKey().getHealthStatus() < 100){
                unhealthyAnimals.put(animal.getKey(), animal.getValue());
            }
        }
        return unhealthyAnimals;
    }

    @Override
    public Animal mating(Animal maleAnimal, Animal femaleAnimal, Animal childAnimal) {
        childAnimal.setSex(femaleAnimal.getSex());
        if(Math.random()>0.5){
            childAnimal.setSex(maleAnimal.getSex());
        }
        return childAnimal;
    }
}
