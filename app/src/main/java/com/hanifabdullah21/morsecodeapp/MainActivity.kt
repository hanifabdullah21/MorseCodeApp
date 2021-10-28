package com.hanifabdullah21.morsecodeapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.hanifabdullah21.morsecodeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //TODO 8. Mengatur Activity
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Menampilkan recyclerview
        binding.mainRv.apply {
            //Atur layoutmanager-nya terlebih dahulu
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            //Pasang adapternya
            adapter = MorseAdapter(
                listOfMorse, object : MorseAdapter.MorseListener {
                    override fun onPlayClicked(morseModel: MorseModel) {
                        //Play sound
                        val mediaPlayer = MediaPlayer.create(this@MainActivity, morseModel.sound!!)
                        mediaPlayer?.start()
                    }
                }
            )
        }

    }
}