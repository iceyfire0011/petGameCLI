package com.company.service.playerService;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.company.enums.FoodType;
import com.company.model.animals.Animal;
import com.company.model.foods.Food;
import com.company.model.players.Player;
import com.company.service.foodService.FoodService;
import com.company.service.foodService.IFoodService;

public class PlayerService implements IPlayerService{

    public static List<Player> players = new LinkedList<Player>();
    IFoodService _foodService;

    public PlayerService(){
        this._foodService = new FoodService();
    }

    @Override
    public String createPlayer(Player player){
        _foodService.initiateFoodWallet(player);
        players.add(player);
        return "New Player Added";
    }

    @Override
    public List<Player> getPlayers(){
        return players;
    }

    //<Helper>
    public void reSerializePlayerAnimalListIndex(Player player){
        /* Re-serializing Animal list index after sell. For example,
            1,cat1 | 2,elephant | 3,cat2 - in old list
            and if we sell 2,elephant
            then the list will be 1,cat1 | 2,cat2
        */
        var tempAnimalMap = new LinkedHashMap<Integer, Animal>();
        for(var animalSerial : player.getAnimals().keySet()){
            tempAnimalMap.put(tempAnimalMap.size() + 1, player.getAnimals().get(animalSerial));
        }
        player.setAnimals(tempAnimalMap);
    }
    //<Helper/>
}
