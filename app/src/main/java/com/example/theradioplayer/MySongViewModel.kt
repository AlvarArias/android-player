package com.example.theradioplayer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MySongViewModel {

    var mySongPlayingNow : String = "mySong"

    private val SongNowPlaying : MutableLiveData<Song> by lazy {
        MutableLiveData<Song>().also {
            loadSong()
        }
    }

    // TODO get list of Radios

    fun getUsers(): LiveData<Song> {

        return SongNowPlaying
    }

    fun loadSong() {

        var mySongAdaptor = SongAdaptor()
        mySongAdaptor.run()
        mySongPlayingNow = mySongAdaptor.theSongName

        Log.i("MYDEBUG", "My new debug")
        Log.i("MYDEBUG", mySongPlayingNow)

    }

}