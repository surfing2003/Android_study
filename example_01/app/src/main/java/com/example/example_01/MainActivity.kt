package com.example.example_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: MutableList<Memo> = loadData()

        var adapter = CustomAdapter()
        adapter.listData = data

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun loadData(): MutableList<Memo>{
        val data: MutableList<Memo> = mutableListOf()

        for (no in 1..100){
            val title = "코틀린 예제 - $no"
            val date = System.currentTimeMillis()
            data.add(Memo(no,title,date))
        }
        return data
    }
}