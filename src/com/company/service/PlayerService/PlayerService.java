package com.company.service.PlayerService;

import java.util.LinkedList;
import java.util.List;

import com.company.model.players.Player;

public class PlayerService implements IPlayerService {

    public static List<Player> players = new LinkedList<Player>();

    @Override
    public String createPlayer(Player player) {
        players.add(player);
        return "New Player Added";
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }


}
