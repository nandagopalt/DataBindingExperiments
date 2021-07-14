package com.example.fragmentcommunicationbyviewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityPlayerViewModel extends ViewModel {
    private static final String TAG = "MainActivityPlayerVM";
    private PlayerRepository playerRepository = new PlayerRepository();

    private MutableLiveData<String> selectedPlayer = new MutableLiveData<>();
    private MutableLiveData<List<String>> mutableLiveDataForPlayersNames = new MutableLiveData<>();
    private MutableLiveData<PlayerModel> mutableLiveDataForSelectedPlayer = new MutableLiveData<>();

    public void setSelectedPlayer(String selectedPlayer) {
        this.selectedPlayer.setValue(selectedPlayer);
    }

    public LiveData<String> getSelectedPlayer() {
        return selectedPlayer;
    }

    public MutableLiveData<List<String>> getPlayersList() {
        Log.d(TAG, "getPlayersList from MainActivityPlayerView" );
        mutableLiveDataForPlayersNames.setValue(playerRepository.getPlayersList());
        return mutableLiveDataForPlayersNames;
    }

    public PlayerModel getPlayerInformation(String name) {
        return playerRepository.getPlayerInformation(name);
    }
}
