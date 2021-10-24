package com.company.application;

import com.company.service.gameService.GameService;
import com.company.service.gameService.IGameService;

import java.util.Scanner;

public class Game{
    IGameService iGameService;

    public Game(){
        this.iGameService = new GameService();
    }


    public void run(){
        Scanner sc = new Scanner(System.in);
        int roundNumber = 1, roundLimit = 0, numberOfPlayer = 0;
        while(numberOfPlayer < 1 || numberOfPlayer > 4){
            System.out.println("Please enter number of player (1-4): ");
            numberOfPlayer = sc.nextInt();
        }
        while(roundLimit < 5 || roundLimit > 30){
            System.out.println("Please enter number of round (5-30): ");
            roundLimit = sc.nextInt();
        }
        System.out.println("Please enter balance for each player: ");
        double balance = sc.nextDouble();
        iGameService.gameControl(numberOfPlayer, roundNumber, roundLimit, balance);
        sc.close();
    }
}
