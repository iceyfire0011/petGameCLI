package com.company.service.PlayerService;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.company.enums.FoodType;
import com.company.model.players.Player;

public class PlayerService implements IPlayerService {

    public static List<Player> players = new LinkedList<Player>();

    @Override
    public String createPlayer(Player player) {
        initiateFoodWallet(player);
        players.add(player);
        return "New Player Added";
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    private void initiateFoodWallet(Player player){
            LinkedHashMap<FoodType, Float> foodWallet = new LinkedHashMap();
            foodWallet.put(FoodType.FISH, 0F);
            foodWallet.put(FoodType.GRAINS, 0F);
            foodWallet.put(FoodType.GRASSES, 0F);
            foodWallet.put(FoodType.MANNA, 0F);
            foodWallet.put(FoodType.MEATS, 0F);
            player.setFoodWallets(foodWallet);
    }
}
