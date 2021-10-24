package com.company.service.foodService;

import com.company.enums.FoodType;
import com.company.model.foods.Food;
import com.company.model.players.Player;

import java.util.LinkedHashMap;

public class FoodService implements IFoodService{

    public void initiateFoodWallet(Player player){
        LinkedHashMap<Integer, Food> foodWallet = new LinkedHashMap();
        for(var foodType : FoodType.values()){
            var food = new Food();
            food.setFoodType(foodType);
            food.setFoodAmount(0);
            foodWallet.put(foodWallet.size() + 1, food);
        }
        player.setFoodWallets(foodWallet);
        player.getFoodWallets().get(1).setFoodPrice(200);
        player.getFoodWallets().get(2).setFoodPrice(40);
        player.getFoodWallets().get(3).setFoodPrice(10);
        player.getFoodWallets().get(4).setFoodPrice(300);
        player.getFoodWallets().get(5).setFoodPrice(400);
    }

    @Override
    public void foodDetailsListByPlayer(Player player){
        System.out.println("Serial \t FoodName \t AvailableAmount \t Price");
        for(var keyItem : player.getFoodWallets().keySet()){
            var food = player.getFoodWallets().get(keyItem);
            System.out.println(keyItem + " \t " + food.getFoodType() + " \t " + food.getFoodAmount() + " \t " + food.getFoodPrice());
        }
    }
}
