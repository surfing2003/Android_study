package com.example.example_09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = SqliteHelper(this, "memo", 1)
        val adapter = RecyclerAdapter()
        adapter.listData.addAll(helper.selectMemo())

        val recyclerMemo = findViewById<RecyclerView>(R.id.recyclerMemo)
        recyclerMemo.adapter = adapter
        recyclerMemo.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.buttonSave).setOnClickListener {
            val editMemo = findViewById<EditText>(R.id.editMemo)
            if (editMemo.text.toString().isNotEmpty()){
                val memo = Memo(null,editMemo.text.toString(),System.currentTimeMillis())

                helper.insertMemo(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()
                editMemo.setText("")
            }

        }
    }
}