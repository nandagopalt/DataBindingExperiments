package com.anushka.viewmodeldemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val initialValue: Int) : ViewModel() {
    private var count = 0
    private val sum = MutableLiveData<Int>()
    val sumLiveData
     get() = sum

    init {
        sum.value = initialValue
    }

    fun add(number:Int){
        sum.value = (sum.value)!!.plus(number)
    }

    fun getCurrentCount():Int{
        return count
    }

    fun getUpdatedCount():Int{
        return ++count
    }
}