package com.example.fragmentcommunicationbyviewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerRepository {

    private static final String TAG = "PlayerRepository";

    private List<String> playerNames = Arrays.asList("Name 1", "Name 2", "Name 3", "Name 4", "Name 5", "Name 6", "Name 7", "Name 8", "Name 9", "Name 10");
    private List<PlayerModel> playersInformationList =
            Arrays.asList(
            new PlayerModel(1, "Name 1", 10),
            new PlayerModel(2, "Name 2", 20),
            new PlayerModel(3, "Name 3", 30),
            new PlayerModel(4, "Name 4", 40),
                    new PlayerModel(5, "Name 5", 50),
                    new PlayerModel(6, "Name 6", 60),
                    new PlayerModel(7, "Name 7", 70),
                    new PlayerModel(8, "Name 8", 80),
                    new PlayerModel(9, "Name 9", 90),
                    new PlayerModel(10, "Name 10", 10));


    public List<String> getPlayersList() {
        Log.d(TAG, "getPlayersList from PlayerRepository");
        return playerNames;
    }

    public PlayerModel getPlayerInformation(String name) {
        PlayerModel player = null;
        for(PlayerModel playerModel : playersInformationList) {
            if(name.trim().equalsIgnoreCase(playerModel.getName().trim())) {
                player = playerModel;
            }
        }
        return player;
    }
}

