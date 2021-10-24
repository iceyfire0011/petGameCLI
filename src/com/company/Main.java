package com.company;

import com.company.application.Game;

public class Main {

    public Game game;

    public Main(){

    }

    public static void main(String[] args){
        Game game = new Game();
        new Main().run(game);
    }

    private void run(Game game) {
        this.game = game;
        System.out.println("STARTING THE Game");
        game.run();
        System.out.println("Game Over!");
    }

}
