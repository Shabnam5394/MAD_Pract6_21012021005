package com.example.mad_pract6_21012021005

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Start = findViewById<FloatingActionButton>(R.id.start)
        Start.setOnClickListener {
            playpause()
        }
        val Stop=findViewById<FloatingActionButton>(R.id.stop)
        Stop.setOnClickListener {
            stop()
        }

    }

    fun playpause() {
        Intent(applicationContext, MyService::class.java).putExtra(MyService.PLAYERKEY, MyService.PLAYERVALUE).apply {
            startService(this)
        }

    }

    fun stop() {
        Intent(applicationContext, MyService::class.java).putExtra(MyService.PLAYERKEY, MyService.PLAYERVALUE).apply {
            stopService(this)
        }
    }
}
