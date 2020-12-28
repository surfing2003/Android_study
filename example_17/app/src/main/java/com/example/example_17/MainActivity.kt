package com.example.example_17

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()

        val adapter = MusicRecyclerAdapter()
        adapter.musicList.addAll(getMusicList())

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun startProcess() {
        setContentView(R.layout.activity_main)
    }

    fun getMusicList(): List<Music> {
        val listUrl = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val proj = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DURATION
        )
        val cursor = contentResolver.query(listUrl,proj,null,null,null)

        val musicList = mutableListOf<Music>()
        while (cursor?.moveToNext() == true) {
            val id = cursor.getString(0)
            val title = cursor.getString(1)
            val artist = cursor.getString(2)
            val albumId = cursor.getString(3)
            val duration = cursor.getLong(4)

            val music = Music(id, title, artist, albumId, duration)
            musicList.add(music)
        }
        return musicList
    }

    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    fun checkPermission() {
        if(ContextCompat.checkSelfPermission(this, permissions[0]) != PackageManager.PERMISSION_GRANTED){
            requestPermission()
        }else{
            startProcess()
        }
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions( this, permissions, 99)
    }

    override fun onRequestPermissionsResult(requestCode: Int
                                            , permissions: Array<out String>
                                            , grantResults: IntArray) {
        if(requestCode == 99){
            var check = true
            for(grant in grantResults) {
                if(grant != PackageManager.PERMISSION_GRANTED){
                    check = false
                    break
                }
            }
            if(!check){
                Toast.makeText(this
                        , "권한요청을 모두 승인해야지만 앱을 실행할 수 있습니다."
                        , Toast.LENGTH_LONG).show()
                finish()
            }else{
                startProcess()
            }
        }
    }
}