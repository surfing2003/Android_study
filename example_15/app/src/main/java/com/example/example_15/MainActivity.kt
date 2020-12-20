package com.example.example_15

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun serviceStart(view: View){
        val intent = Intent(this, MyService::class.java)
        intent.action = MyService.ACTION_START
        startService(intent)
    }

    fun serviceStop(view: View){
        val intent = Intent(this,MyService::class.java)
        stopService(intent)
    }

    var myService:MyService? = null
    var isService = false
    val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder){
            val binder = service as MyService.MyBinder
            myService = binder.getService()
            isService = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isService = false
        }
    }

    fun serviceBind(view: View){
        val intent = Intent(this, MyService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    fun serviceUnbind(view: View){
        if(isService){
            unbindService(connection)
            isService = false
        }
    }

    fun callServiceFunction(view: View){
        if(isService){
            val message = myService?.serviceMessage()
            Toast.makeText(this, "message=${message}",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "서비스 연결 X",Toast.LENGTH_LONG).show()
        }
    }
}