package com.example.databindingexample4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingexample4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        binding.student = getStudent()
        /*val student:Student = getStudent()
        binding.apply {
            name.text = student.name
            email.text = student.email
        }*/
    }

    private fun getStudent() : Student {
        return Student(1,"Name 1", "Name1@gmail.com")
    }
}