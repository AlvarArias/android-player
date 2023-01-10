package com.example.theradioplayer

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.*
import kotlin.system.*


class MainActivityViewModel: ViewModel() {

    var mySongTest = Song()
    var valthetest = "The test of Test View Controller"
    val mySongAdaptor = SongAdaptor()

     fun startTest() = runBlocking<Unit> {

         startTest1()
         startTest2()

    }

    private suspend fun startTest1() {
        Log.i("MYDEBUG", "fun startTest1()")
        mySongAdaptor.run()
    }
    private suspend fun startTest2() {
        delay(4000L)
        Log.i("MYDEBUG", "fun startTest2()")
        Log.i("MYDEBUG", mySongAdaptor.mySongNow.artist)
    }


}