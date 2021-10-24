package com.company.service.gameService;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.company.PropertyConstant;
import com.company.model.animals.*;
import com.company.model.players.Player;
import com.company.service.animalService.AnimalService;
import com.company.service.animalService.IAnimalService;
import com.company.service.foodService.FoodService;
import com.company.service.foodService.IFoodService;
import com.company.service.playerService.IPlayerService;
import com.company.service.playerService.PlayerService;
import com.company.service.storeService.IStoreService;
import com.company.service.storeService.StoreService;

public class GameService implements IGameService{

    IPlayerService _playerService;
    IAnimalService _animalService;
    IStoreService _storeService;
    IFoodService _foodService;

    public GameService(){
        this._playerService = new PlayerService();
        this._animalService = new AnimalService();
        this._storeService = new StoreService();
        this._foodService = new FoodService();
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
            player.setAnimals(new LinkedHashMap<>());
            System.out.println(_playerService.createPlayer(player));
        }
        while(roundNumber < roundLimit + 1){
            for(var player : _playerService.getPlayers()){
                System.out.println("Round " + roundNumber + ": Turn for Player " + player.getId() + "-> " + player.getName());
                boolean turnFinish = false;
                while(!turnFinish){
                    System.out.println("Dear player " + player.getName() + "; Your current Balance is: " + player.getBalance());
                    System.out.println("Available animal list:\n");
                    _animalService.animalDetailsListByPlayer(player);
                    System.out.println("Available Food list:\n");
                    _foodService.foodDetailsListByPlayer(player);
                    printInstruction();
                    int finishTurn = scanner.nextInt();
                    switch(finishTurn){
                        case 0://finish turn
                            for(var key : player.getAnimals().keySet()){
                                var animal = player.getAnimals().get(key);
                                _animalService.changeHealth(animal, -PropertyConstant.HEALTH_VARIATION);
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
                                System.out.println("male? press- 1");
                                System.out.println("female? press- 2");
                                _animalService.chooseGender(animal, scanner.nextInt());
                                _storeService.buyAnimal(player, animal);
                            }else{
                                System.out.println("Wrong input! Please try again");
                            }
                            break;
                        case 2://purchase food
                            System.out.println("Please select a Food:");
                            chooseFoodInstruction();
                            int foodOption = scanner.nextInt();
                            System.out.println("Please select amount in kg:");
                            int foodAmount = scanner.nextInt();
                            _storeService.buyFood(player, foodOption, foodAmount);
                            break;
                        case 3://feed animal
                            if(_animalService.isPlayerHasAnimal(player)){
                                System.out.println("Please select an animal to feed:");
                                int animalSerial = scanner.nextInt();
                                System.out.println("Please select a food to feed:");
                                int foodSerial = scanner.nextInt();
                                System.out.println("Please select amount of food to feed:");
                                double amount = scanner.nextDouble();
                                _animalService.feedAnimalByPlayer(player, animalSerial, foodSerial, amount);
                            }else{
                                System.out.println("You don't have animal. Please buy animal first");
                            }
                            break;
                        case 4://sell animal
                            if(_animalService.isPlayerHasAnimal(player)){
                                //_animalService.animalDetailsListByPlayer(player);
                                System.out.println("Please choose an animal to sell by giving serial no as input:");
                                int serial = scanner.nextInt();
                                _storeService.sellAnimal(player, serial);
                                _playerService.reSerializePlayerAnimalListIndex(player);
                            }else{
                                System.out.println("You don't have animal. Please buy animal first");
                            }
                            break;
                        case 5://sell food
                            //_foodService.foodDetailsListByPlayer(player);
                            System.out.println("Please choose a food to sell by giving serial no as input:");
                            int serial = scanner.nextInt();
                            System.out.println("Please input amount of food for sell:");
                            int amount = scanner.nextInt();
                            _storeService.sellFood(player, serial, amount);
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

    private void chooseFoodInstruction(){
        System.out.println("Fish? press- 1");
        System.out.println("Grains? press- 2");
        System.out.println("Grasses? press- 3");
        System.out.println("Manna? press- 4");
        System.out.println("Meats? press- 5");
        System.out.println("Back to main menu? press- 0");
    }


}
