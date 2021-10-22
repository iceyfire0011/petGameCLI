package com.company.service.GameService;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.company.enums.FoodType;
import com.company.enums.Gender;
import com.company.model.animals.*;
import com.company.model.foods.Food;
import com.company.model.players.Player;
import com.company.service.AnimalService.AnimalService;
import com.company.service.AnimalService.IAnimalService;
import com.company.service.PlayerService.IPlayerService;
import com.company.service.PlayerService.PlayerService;
import com.company.service.StoreService.IStoreService;
import com.company.service.StoreService.StoreService;

public class GameService implements IGameService{

    IPlayerService _playerService;
    IAnimalService _animalService;
    IStoreService _storeService;

    public GameService(){
        this._playerService = new PlayerService();
        this._animalService = new AnimalService();
        this._storeService = new StoreService();
    }

    @Override
    public int gameRun(int numberOfPlayer, int roundNumber, int roundLimit, double balance){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < numberOfPlayer; i++){
            Player player = new Player();
            player.setId(i + 1);
            System.out.println("Please enter player name for player" + player.getId() + ":");
            player.setName(scanner.next());
            player.setBalance(balance);
            player.setAnimals(new LinkedList<Animal>());
            _playerService.createPlayer(player);
        }
        while(roundNumber < roundLimit + 1){
            for(var player : _playerService.getPlayers()){
                System.out.println("Round " + roundNumber + ": Turn for Player " + player.getId() + "-> " + player.getName());
                boolean turnFinish = false;
                while(!turnFinish){
                    printInstruction();
                    int finishTurn = scanner.nextInt();
                    switch(finishTurn){
                        case 0://finish turn
                            for(var animal : player.getAnimals()){
                                animal.setHealthStatus(animal.getHealthStatus() - 10);
                            }
                            turnFinish = true;
                            break;
                        case 1://purchase animal
                            System.out.println("Please select an animal:");
                            chooseAnimalInstruction();
                            int animalOption = scanner.nextInt();
                            Animal animal = _animalService.animalFactory(animalOption);
                            if(animal != null){
                                System.out.println("Please select gender:");
                                _animalService.chooseGender(animal, scanner.nextInt());
                                _storeService.buyAnimal(player, animal);
                            }else{
                                finishTurn = 1;
                            }
                            break;
                        case 2://purchase food
                            break;
                        case 3://feed animal
                            break;
                        case 4://sell animal
                            break;
                        case 5://sell food
                            break;
                        case 6://send matting
                            break;
                        default:
                            System.out.println("Wrong input. Please select menu from instruction");
                    }
                }
            }
            roundNumber++;
        }
        for(var player : _playerService.getPlayers()){
            for(var animal : player.getAnimals()){
                System.out.println(player.getName() + "," + animal.getAnimalName());
            }
        }
        System.out.println(numberOfPlayer + ", " + roundNumber + ", " + roundLimit + ", " + balance);
        scanner.close();
        return 0;
    }

    private void printInstruction(){
        System.out.println("Want to purchase Animal? press- 1");
        System.out.println("Want to purchase Food? press- 2");
        System.out.println("Want to feed Animal? press- 3");
        System.out.println("Want to sell Animal? press- 4");
        System.out.println("Want to sell Food? press- 5");
        System.out.println("Want to send for Mating? press- 6");
        System.out.println("Want to finish turn? press- 0");
    }

    private void chooseAnimalInstruction(){
        System.out.println("Cat? press- 1");
        System.out.println("Elephant? press- 2");
        System.out.println("Guppy? press- 3");
        System.out.println("Mouse? press- 4");
        System.out.println("Back to main menu? press- 0");
    }


}
