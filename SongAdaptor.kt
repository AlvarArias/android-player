package com.example.theradioplayer

import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import okio.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class SongAdaptor {

    // New song object
    var mySongNow = Song()

    var theSongName : String = ""

    private val client = OkHttpClient()


    fun run() : String {
        Log.i("MYDEBUG", "function run()")

        val temaradio = "https://api.sr.se/api/v2/playlists/rightnow?channelid=2562&format=JSON"

        val request = Request.Builder()
            .url(temaradio)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("MYDEBUG", "FAILURE")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    Log.i("MYDEBUG", "Response")

                    if (!response.isSuccessful) throw IOException("Unexpected code $response")


                    val responseText = response.body!!.string()

                    Log.i("MYDEBUG" , responseText)


                    var songNow = Gson().fromJson(responseText, Codebeautify::class.java)

                    if (songNow.playlist?.song != null) {

                        mySongNow.title = songNow.playlist!!.song!!.title!!.toString()
                        mySongNow.albumname = songNow.playlist!!.song!!.albumname!!.toString()
                        mySongNow.artist = songNow.playlist!!.song!!.artist!!.toString()


                        var thetitle = songNow.playlist!!.song!!.title!!.toString()
                        var thedatestart = songNow.playlist!!.song!!.starttimeutc!!
                        val newdatestart = thedatestart

                        // Remove /Date( an )/
                        val numDate =  newdatestart.removePrefix("/Date(").removeSuffix(")/").toLong()
                        //Log.i("MYDEBUG", numDate.toString())

                        theSongName = thetitle


                        Log.i("MYDEBUG", thetitle)
                        Log.i("MYDEBUG", theSongName)
                        Log.i("MYDEBUG", mySongNow.artist)
                        //Log.i("MYDEBUG", songNow.playlist!!.song!!.description!!.toString())
                        //Log.i("MYDEBUG", songNow.playlist!!.song!!.artist!!.toString())
                        //Log.i("MYDEBUG", songNow.playlist!!.song!!.composer!!.toString())
                        //Log.i("MYDEBUG", thedatestart.toString())
                        //Log.i("MYDEBUG", songNow.playlist!!.song!!.stoptimeutc!!.toString())

                        // time in the system now
                        var seconds1 = System.currentTimeMillis()
                        //Log.i("MYDEBUG", System.currentTimeMillis().toString())

                        var format: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
                        //var formatted: String = format.format(seconds1)
                        var formatted: String = format.format(numDate)

                        //Log.i("MYDEBUG", formatted)


                    } else {
                        Log.i("MYDEBUG", "songNow.playlist?.song = null")
                    }
                }
            }
        })

        return theSongName
    }

}