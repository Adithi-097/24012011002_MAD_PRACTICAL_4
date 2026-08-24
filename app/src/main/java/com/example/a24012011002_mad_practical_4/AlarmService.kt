package com.example.a24012011002_mad_practical_4

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class AlarmService : Service() {

    var np: MediaPlayer? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            if (np == null) {
                np = MediaPlayer.create(this, R.raw.alarm)
            }
            np?.start()
        }
        return START_STICKY

    }

    override fun onDestroy() {
        np?.stop()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}