package com.example.example_15

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Log.d("StartedService","action=$action")
        return super.onStartCommand(intent, flags, startId)

    }
    companion object {
        val ACTION_START = "com.example.example_15.START"
        val ACTION_RUN = "com.example.example_15.RUN"
        val ACTION_STOP = "com.example.example_15.STOP"
    }

    override fun onDestroy() {
        Log.d("Service","서비스가 종료")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}