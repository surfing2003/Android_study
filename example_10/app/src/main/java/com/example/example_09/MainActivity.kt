package com.example.example_09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    var helper: RoomHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        helper = Room.databaseBuilder(this,RoomHelper::class.java,"room_memo"). allowMainThreadQueries().build()
        val adapter = RecyclerAdapter()
        adapter.helper = helper
        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())



        val recyclerMemo = findViewById<RecyclerView>(R.id.recyclerMemo)
        recyclerMemo.adapter = adapter
        recyclerMemo.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.buttonSave).setOnClickListener {
            val editMemo = findViewById<EditText>(R.id.editMemo)
            if (editMemo.text.toString().isNotEmpty()){
                val memo = RoomMemo(editMemo.text.toString(),System.currentTimeMillis())

                helper?.roomMemoDao()?.insert(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
                adapter.notifyDataSetChanged()
                editMemo.setText("")
            }

        }
    }
}