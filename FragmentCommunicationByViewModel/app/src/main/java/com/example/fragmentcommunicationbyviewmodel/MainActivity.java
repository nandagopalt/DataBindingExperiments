package com.example.fragmentcommunicationbyviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.fragmentcommunicationbyviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        //setContentView(R.layout.activity_main);
        setContentView(activityMainBinding.getRoot());
        //toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitleTextColor(Color.RED);
        activityMainBinding.toolbar.setSubtitle("Tennis Players");
        setSupportActionBar(activityMainBinding.toolbar);
    }
}