package com.company.service.GameService;

import java.util.Scanner;

import com.company.model.players.Player;
import com.company.service.AnimalService.AnimalService;
import com.company.service.AnimalService.IAnimalService;
import com.company.service.PlayerService.IPlayerService;
import com.company.service.PlayerService.PlayerService;

public class GameService implements IGameService{

    IPlayerService _playerService;
    IAnimalService _animalService;

    public GameService(){
        this._playerService = new PlayerService();
        this._animalService = new AnimalService();
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
            _playerService.createPlayer(player);
        }
        while(roundNumber < roundLimit+1){
            for(var player : _playerService.getPlayers()){
                System.out.println("Round " + roundNumber + ": Turn for Player " + player.getId() + "-> " + player.getName());
                boolean turnFinish=false;
                while(!turnFinish){
                   printInstruction();
                    int finishTurn = scanner.nextInt();
                    switch (finishTurn){
                        case 0:
                            turnFinish=true;
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        default:
                    }
                }
            }
            roundNumber++;
        }

        System.out.println(numberOfPlayer + ", " + roundNumber + ", " + roundLimit + ", " + balance);
        scanner.close();
        return 0;
    }

    @Override
    public void printInstruction() {
        System.out.println("Want to finish turn? press- 0");
        System.out.println("Want to purchase Animal? press- 1");
        System.out.println("Want to purchase Food? press- 2");
        System.out.println("Want to feed Animal? press- 3");
        System.out.println("Want to sell Animal? press- 4");
        System.out.println("Want to sell Food? press- 5");
        System.out.println("Want to send for Mating? press- 6");
    }
}
