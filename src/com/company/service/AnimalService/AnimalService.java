package com.company.service.AnimalService;

import com.company.enums.Gender;
import com.company.model.animals.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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
                animal=new Mouse();
                break;
            default:
                System.out.println("Wrong input! Please select an animal");
        }
        return animal;
    }

    public void chooseGender(Animal animal, int genderChoice){
        System.out.println("male? press- 1");
        System.out.println("female? press- 2");
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
}
