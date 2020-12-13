package com.example.example_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textList = listOf("뷰A", "뷰B", "뷰C", "뷰D")
        val adapter = CustomPagerAdapter()
        adapter.textList = textList

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = adapter


        val tabTitles = listOf("View A", "View B", "View C", "View D")
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
