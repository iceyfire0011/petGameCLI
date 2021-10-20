package com.company.service.GameService;

public interface IGameService{
    int gameRun(int numberOfPlayer, int roundNumber, int roundLimit, double balance);
    void printInstruction();
}
