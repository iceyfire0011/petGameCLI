package com.company.service.GameService;

public interface IGameService{
    int roundIncrementer(int currentRound,int roundLimit);
    int gameRun(int numberOfPlayer, int roundNumber, int roundLimit, double balance);
}
