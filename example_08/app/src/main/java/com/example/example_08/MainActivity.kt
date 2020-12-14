package com.example.example_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = PreferenceManager.getDefaultSharedPreferences(this)
        val checkboxValue = shared.getBoolean("key_add_shortcut",false)
        val switchValue = shared.getBoolean("key_switch_on",false)
        val name = shared.getString("key_edit_name","")
        val selected = shared.getString("key_set_item","")

        Log.d("Shared Preference", "add_shortcut=${checkboxValue}")
        Log.d("Shared Preference", "switchValue=${switchValue}")
        Log.d("Shared Preference", "name=${name}")
        Log.d("Shared Preference", "selected=${selected}")
    }


}