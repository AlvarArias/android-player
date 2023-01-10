package com.example.theradioplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instal framneto inicial
         supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, SongPlayNowFragment()).commit()
        // crea variable frament
        val myfrag = findViewById<FragmentContainerView>(R.id.fragmentContainerView)


        val my_button = findViewById<Button>(R.id.button)
        val my_song_name = findViewById<TextView>(R.id.my_text)
        var myAdaptor = RadioAdaptor()

        my_button.setOnClickListener {
            Log.i("MYDEBUG", "Click Button")

            var viewModel: MainActivityViewModel
            viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

            //viewModel.startTest()
            findViewById<TextView>(R.id.my_text).text = viewModel.valthetest
            Log.i("MYDEBUG", viewModel.valthetest.toString())
            viewModel.startTest()

            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, TwoFragment()).commit()


        }



    }
}