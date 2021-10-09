package com.company.service.GameService;


public class GameService implements IGameService{
    public int roundIncrementer(int currentRound, int roundLimit){
        if(currentRound == roundLimit){
            return -1;
        }
        return currentRound++;
    }

    @Override
    public int gameRun(int numberOfPlayer, int roundNumber, int roundLimit, double balance){

        System.out.println(numberOfPlayer + ", " + roundNumber + ", " + roundLimit + ", " + balance);
        return 0;
    }
}
