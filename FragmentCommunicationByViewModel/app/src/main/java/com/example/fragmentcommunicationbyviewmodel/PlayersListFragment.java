package com.example.fragmentcommunicationbyviewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentcommunicationbyviewmodel.databinding.FragmentPlayersBinding;

import java.util.List;

public class PlayersListFragment extends Fragment {

    private static final String TAG = "PlayersListFragment";

    //private ListView listView;
    private MainActivityPlayerViewModel playerViewModel;

    private FragmentPlayersBinding fragmentPlayersBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentPlayersBinding = FragmentPlayersBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.fragment_players, container, false);
        //listView = view.findViewById(R.id.listView);
        return fragmentPlayersBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerViewModel = new ViewModelProvider(requireActivity()).get(MainActivityPlayerViewModel.class);
        playerViewModel.getPlayersList().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> playersNamesList) {
                fragmentPlayersBinding.listView.setAdapter(new ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, playersNamesList) {
                });
            }
        });

        fragmentPlayersBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playerViewModel.setSelectedPlayer(((TextView)view).getText().toString());
            }
        });
    }



}