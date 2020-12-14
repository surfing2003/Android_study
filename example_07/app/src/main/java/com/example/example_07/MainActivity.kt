package com.example.example_07

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnPermission).setOnClickListener {
            checkPermission()
        }
    }

    fun checkPermission(){
        val cameraPermission = ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)

        if (cameraPermission == PackageManager.PERMISSION_GRANTED){
            // 상태가 승인인 경우
            startProcess()
        } else {
            // 상태가 승인이 아닌 경우
            requestPermissions()
        }

    }

    fun startProcess(){
        Toast.makeText(this,"카메라 권한 확인 완료",Toast.LENGTH_LONG).show()
    }

    fun requestPermissions(){
        ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CAMERA),99)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode){
            99 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startProcess()
                } else {
                    finish()
                }
            }
        }
    }
}