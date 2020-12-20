package com.example.example_13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var total = 0
        var started = false
        val textTimer = findViewById<TextView>(R.id.textTimer)

        val handler = object: Handler(){
            override fun handleMessage(msg: Message) {
                val minute = String.format("%02d",total/60)
                val second = String.format("%02d",total%60)
                textTimer.text = "$minute:$second"
            }
        }

        findViewById<Button>(R.id.buttonStart).setOnClickListener {
            started = true
            thread(start=true){
                while(started){
                    Thread.sleep(1000)
                    if(started){
                        total += 1
                        handler?.sendEmptyMessage(0)
                    }
                }
            }
        }

        findViewById<Button>(R.id.buttonStop).setOnClickListener {
            if (started){
                started = false
                total = 0
                textTimer.text = "00:00"
            }
        }

    }
}