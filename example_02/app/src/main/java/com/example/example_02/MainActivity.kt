package com.example.example_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    fun setFragment() {
        val listFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.frameLayout,listFragment)
        transaction.commit()
    }

    fun goDetail(){
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout,detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack(){
        onBackPressed()
    }
}

