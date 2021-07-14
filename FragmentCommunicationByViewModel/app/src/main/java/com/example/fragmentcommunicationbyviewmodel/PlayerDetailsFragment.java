package com.example.fragmentcommunicationbyviewmodel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentcommunicationbyviewmodel.databinding.FragmentPlayerDetailsBinding;

public class PlayerDetailsFragment extends Fragment {
    private static final String TAG = "PlayerDetailsFragment";

    private MainActivityPlayerViewModel playerViewModel;
    private FragmentPlayerDetailsBinding fragmentPlayerDetailsBinding;
    //private TextView name, age;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d(TAG, "onCreateView");
        //View view = inflater.inflate(R.layout.fragment_player_details, container, false);
        fragmentPlayerDetailsBinding = FragmentPlayerDetailsBinding.inflate(inflater, container, false);
        //this.name = (TextView) view.findViewById(R.id.name);
        //this.age = (TextView) view.findViewById(R.id.age);
        return fragmentPlayerDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        playerViewModel = new ViewModelProvider(requireActivity()).get(MainActivityPlayerViewModel.class);
        playerViewModel.getSelectedPlayer().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                displayInformation(playerViewModel.getPlayerInformation(s));
            }
        });
    }

    private void displayInformation(PlayerModel playerModel) {
        Log.d(TAG, "displayInformation : " + playerModel);
        fragmentPlayerDetailsBinding.setPlayer(playerModel);
        /*fragmentPlayerDetailsBinding.name.setText(playerModel.getName());
        fragmentPlayerDetailsBinding.age.setText(String.valueOf(playerModel.getAge()));*/
    }
}
