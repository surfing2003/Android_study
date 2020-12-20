package com.example.example_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var thread_0 = WorkerThread()
        thread_0.start()

        var thread_1 = Thread(WorkerRunnable())
        thread_1.start()

        Thread {
            var i = 0
            while (i < 10){
                i += 1
                Log.i("Lambda Thread","$i")
            }
        }.start()

        thread(start=true){
            var i = 0
            while(i < 10){
                i += 1
                Log.i("Kotlin Thread","$i")
            }
        }
    }
}
class WorkerRunnable : Runnable{
    override fun run(){
        var i = 0
        while(i < 10){
            i += 1
            Log.i("Runnable Thread","$i")
        }
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

