package com.example.theradioplayer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.internal.wait


class MyViewModel: ViewModel() {

var mySongNow = User()


private val users: MutableLiveData<List<User>> by lazy {
    MutableLiveData<List<User>>().also {
        loadSong()
    }
}

    // TODO get list of Radios

    fun getUsers(): LiveData<List<User>> {

        return users
    }

    fun loadSong() {

        val mySongAdaptor = SongAdaptor()
        mySongNow.myartist = mySongAdaptor.run()
        //mySongNow.myartist = mySongAdaptor.theSongName

        Log.i("MYDEBUG", "My new debug")
        //Log.i("MYDEBUG", mySongNow.myartist.toString())

    }

}

class User {
    var mytitle : String? = null
    var myalbumname: String? = null
    var myartist: String? = null
}


