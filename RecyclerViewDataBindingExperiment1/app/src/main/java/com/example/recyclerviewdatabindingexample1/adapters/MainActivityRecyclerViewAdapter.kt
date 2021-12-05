package com.example.recyclerviewdatabindingexample1.viewcontrollers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdatabindingexample1.R
import com.example.recyclerviewdatabindingexample1.databinding.RowItemBinding
import com.example.recyclerviewdatabindingexample1.viewcontrollers.model.Fruit

class MainActivityRecyclerViewAdapter(
    private val fruitList: List<Fruit>,
    private val clickListener: (Fruit) -> Unit
) : RecyclerView.Adapter<MainActivityRecyclerViewAdapter.MainActivityRCViewHolder>() {
    override fun onCreateViewHolder(
        container: ViewGroup,
        viewType: Int
    ): MainActivityRCViewHolder {
        val layoutInflater = LayoutInflater.from(container.context)
        val listItemBinding = RowItemBinding.inflate(layoutInflater, container, false)
        return MainActivityRCViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(
        holder: MainActivityRCViewHolder,
        position: Int
    ) {
        holder.bind(fruitList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    inner class MainActivityRCViewHolder(private val bindingListItem: RowItemBinding) : RecyclerView.ViewHolder(bindingListItem.root) {
        fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
            bindingListItem.fruit = fruit
            bindingListItem.container.setOnClickListener {
                clickListener(fruit)
            }
        }

    }
}

