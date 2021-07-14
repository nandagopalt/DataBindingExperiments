package com.example.databindingexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingexample2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        //val button:Button = findViewById(R.id.submit_button);
        binding.submitButton.setOnClickListener {
            displayGreeting()
        }
    }

    private fun displayGreeting() {
        //val textView:TextView = findViewById(R.id.greet_person_textview);
        //val editText:EditText = findViewById(R.id.person_name_edittext);
        binding.apply {
            greetPersonTextview.text = "Hello " + personNameEdittext.text
        }

    }
}

