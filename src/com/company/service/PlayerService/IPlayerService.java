package com.company.service.PlayerService;

import java.util.List;

import com.company.model.players.Player;

public interface IPlayerService{
    String createPlayer(Player player);
    List<Player> getPlayers();
}
