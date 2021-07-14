package com.example.databindingexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.databindingexample3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var button:Button
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main)
        //button = findViewById(R.id.submitButton)
        binding.submitButton.setOnClickListener {
            startOrStopProgressBar()
        }
    }

    private fun startOrStopProgressBar() {
        //val progressBar: ProgressBar = findViewById<ProgressBar>(R.id.progressBar)
        //val button:Button = findViewById(R.id.submitButton)
        binding.apply {
        if(progressBar.isVisible) {
            submitButton.text = "STOP"
            progressBar.visibility = View.GONE
        } else {
            submitButton.text = "START"
            progressBar.visibility = View.VISIBLE
        }
        }
    }
}