package com.example.recyclerviewdatabindingexample1.viewcontrollers.viewcontrollers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdatabindingexample1.R
import com.example.recyclerviewdatabindingexample1.databinding.ActivityMainBinding
import com.example.recyclerviewdatabindingexample1.viewcontrollers.adapters.MainActivityRecyclerViewAdapter
import com.example.recyclerviewdatabindingexample1.viewcontrollers.model.Fruit

class MainActivity : AppCompatActivity() {
    private val fruitList =
        listOf<Fruit>(
            Fruit("Mango", "Mango Vendor"),
            Fruit("Apple", "Apple Vendor"),
            Fruit("Banana", "Banana Vendor"),
            Fruit("Orange", "Orange Vendor"),
            Fruit("Kiwi", "Kiwi Vendor"),
            Fruit("Carrot", "Carrot Vendor"),
            Fruit("Dragon Fruit", "Dragon Fruit Vendor")
        )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            recyclerView.setBackgroundColor(Color.BLUE)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = MainActivityRecyclerViewAdapter(
                fruitList
            ) { selectedFruit: Fruit -> onFruitItemClicked(selectedFruit) }
        }
    }

    private fun onFruitItemClicked(fruit: Fruit) {
        Toast.makeText(
            this@MainActivity,
            "Fruit name and Vendor : ${fruit.name} and ${fruit.vendor}",
            Toast.LENGTH_SHORT
        ).show()
    }
}