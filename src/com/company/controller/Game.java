package com.company.controller;

import com.company.service.GameService.GameService;
import com.company.service.GameService.IGameService;

import java.util.Scanner;

public class Game{
    IGameService iGameService;

    public Game(){
        this.iGameService = new GameService();
    }


    public void gameInit(){
        Scanner sc = new Scanner(System.in);
        int roundNumber = 0, roundLimit = 0, numberOfPlayer = 0;
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
        iGameService.gameRun(numberOfPlayer, roundNumber, roundLimit, balance);
    }

    public String gameFinish(String playerName){
        return "Congratulation! The winner is: " + playerName;
    }
}
