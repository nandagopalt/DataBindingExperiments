package com.anushka.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.countText.text = viewModel.sumLiveData.value.toString()

        binding.button.setOnClickListener {
            viewModel.add(binding.editTextNumber.text.toString().toInt())
        }

        viewModel.sumLiveData.observe(this, Observer {
            binding.countText.text = it.toString()
        })

        /*binding.countText.text = viewModel.getCurrentCount().toString()

        binding.button.setOnClickListener {

            binding.countText.text = viewModel.getUpdatedCount().toString()
        }*/
    }
}
