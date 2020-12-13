package com.example.example_00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = listOf("-선택하세요-","1월","2월","3월","4월","5월","6월")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val result = findViewById<TextView>(R.id.result)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = data.get(position)
            }
        }


    }
}