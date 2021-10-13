package com.company.service.GameService;

import java.util.Scanner;

import com.company.model.players.Player;
import com.company.service.PlayerService.IPlayerService;
import com.company.service.PlayerService.PlayerService;

public class GameService implements IGameService {

    IPlayerService _playerService;

    

    public GameService() {
        this._playerService = new PlayerService();
    }

    public int roundIncrementer(int currentRound, int roundLimit) {
        if (currentRound == roundLimit) {
            return -1;
        }
        return currentRound++;
    }

    @Override
    public int gameRun(int numberOfPlayer, int roundNumber, int roundLimit, double balance) {

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfPlayer; i++) {
            Player player = new Player();
            player.setId(i+1);
            System.out.println("Please enter player name for player" + player.getId()+":");
            player.setName(scanner.next());
            player.setBalance(balance);
            _playerService.createPlayer(player);
        }

        // for ( var plItem : _playerService.getPlayers()) {
        //     System.out.println(plItem.toString());
        // }

        System.out.println(numberOfPlayer + ", " + roundNumber + ", " + roundLimit + ", " + balance);
        scanner.close();
        return 0;
    }
}
