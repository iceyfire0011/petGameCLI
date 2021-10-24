package com.company.service.foodService;

import com.company.model.foods.Food;
import com.company.model.players.Player;

public interface IFoodService{
    void initiateFoodWallet(Player player);

    void foodDetailsListByPlayer(Player player);
}
