package com.example.exerciseprogrammingwithfriends

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    val data =ArrayList<sample6data>()
    val Livedata = MutableLiveData<ArrayList<sample6data>>()


    fun mydata() {
        data.clear()
        for (i in 0 until 10) {
            val sampledata = sample6data("" + i, "" + i)
            data.add(sampledata)
        }
        Livedata.value = data

    }
}
