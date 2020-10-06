package com.e.livedataexp.model

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Saveconfig : ViewModel() {

    var incre = MutableLiveData<Int>();
    var hand = Handler()
    var count = 0

    // if we put any function return type as live data then we can set observer in main activity
    fun starttimer(): LiveData<Int>
    {
        hand = Handler()
        hand.postDelayed(object : Runnable {
            override fun run() {
                //Call your function here
                incre.value = count++
                hand.postDelayed(this, 1000)//1 sec delay
            }
        }, 0)
        return incre
    }

    fun stoptimer()
    {
        hand.removeCallbacksAndMessages(null);
        incre.value = 0;
        count = 0
    }
}

