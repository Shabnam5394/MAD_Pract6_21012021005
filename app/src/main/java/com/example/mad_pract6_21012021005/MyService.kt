package com.example.mad_pract6_21012021005

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    lateinit var Player : MediaPlayer
    companion object{
        val PLAYERKEY="service"
        val PLAYERVALUE="play/pause"
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!this::Player.isInitialized){
            Player= MediaPlayer.create(this,R.raw.song)

        }
        if(intent!=null){
            val datavalue=intent.getStringExtra(PLAYERKEY)
            if(datavalue== PLAYERVALUE){
                if(!Player.isPlaying){
                    Player.start()
                }
                else{
                    Player.pause()
                }
            }
        }
        else{
            Player.stop()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Player.stop()
        super.onDestroy()
    }
}