package com.example.example_15

import android.app.Service
import android.content.Intent
import android.os.Binder
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

    inner class MyBinder : Binder(){
        fun getService(): MyService{
            return this@MyService
        }
    }

    val binder = MyBinder()
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun serviceMessage(): String{
        return "Hello Activity! I am Service!"
    }


}