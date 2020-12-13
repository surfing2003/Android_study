package com.example.example_03

import android.content.Context
import android.graphics.*
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

            val blue = Paint()
            blue.style = Paint.Style.FILL
            blue.color = Color.BLUE
            canvas?.drawCircle(150f,300f,100f,blue)

            val red = Paint()
            red.style = Paint.Style.STROKE
            red.color = Color.RED
            canvas?.drawCircle(400f,300f,100f,red)

            val green = Paint()
            green.style = Paint.Style.STROKE
            green.strokeWidth = 20f
            green.color = Color.GREEN
            val rect = Rect(50,450,250,650)
            canvas?.drawRect(rect,green)

            val cyan = Paint()
            cyan.style = Paint.Style.FILL
            cyan.color = Color.CYAN
            val rectF = RectF(300f,450f,500f,650f)
            canvas?.drawRoundRect(rectF,50f,50f,cyan)
        }
    }
}