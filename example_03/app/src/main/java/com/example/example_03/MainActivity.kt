package com.example.example_03

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customView = CustomView("안녕 코틀린!",this)
        findViewById<FrameLayout>(R.id.frameLayout).addView(customView)
    }

    class CustomView(text: String, context: Context): View(context){

        val text: String = text

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            val paint = Paint()
            paint.color = Color.BLACK
            paint.textSize = 100F
            canvas?.drawText(text,0f,100f,paint)
        }
    }
}