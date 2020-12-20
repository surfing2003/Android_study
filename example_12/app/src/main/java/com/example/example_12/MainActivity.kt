package com.example.example_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var thread = WorkerThread()
        thread.start()
    }
}
class WorkerThread : Thread(){
    override fun run(){
        var i = 0
        while(i < 10){
            i += 1
            Log.i("Worker Thread","$i")

        }
    }
}