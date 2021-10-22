package com.company.service.PlayerService;

import java.util.LinkedHashMap;
import java.util.List;

import com.company.enums.FoodType;
import com.company.model.players.Player;

public interface IPlayerService{
    String createPlayer(Player player);

    List<Player> getPlayers();
}
