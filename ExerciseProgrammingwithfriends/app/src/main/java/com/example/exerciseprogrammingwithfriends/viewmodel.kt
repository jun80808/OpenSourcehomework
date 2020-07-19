package com.example.exerciseprogrammingwithfriends

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    val listdata =ArrayList<items>()
    val Livedata = MutableLiveData<ArrayList<items>>()


    fun mydata() {
        listdata.clear()
        for (i in 0 until 40) {
            val sampledata = items("" + i, "" + i)
            items.add(sampledata)
        }
        Livedata.value = listdata

    }
}
