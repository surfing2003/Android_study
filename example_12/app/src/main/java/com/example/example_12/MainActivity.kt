package com.example.example_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

// 메인 스레드가 아닌 작업스레드에서 UI변경의 작업이 일어나면 오류가 발생
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        Thread {
//            var i = 0
//            while (i < 10){
//                findViewById<TextView>(R.id.textView).text = "$i"
//                i += 1
//                Thread.sleep(1000)
//            }
//        }.start()
//    }
//}