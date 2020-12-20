package com.example.example_14

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editUrl = findViewById<EditText>(R.id.editUrl)
        findViewById<Button>(R.id.buttonDownload).setOnClickListener {
            val asyncTask = object : AsyncTask<String, Void, Bitmap?>(){
                override fun doInBackground(vararg params: String?): Bitmap? {
                    val urlString = params[0]!!
                    try{
                        val url = URL(urlString)
                        val stream = url.openStream()
                        return BitmapFactory.decodeStream(stream)
                    } catch(e: Exception){
                        e.printStackTrace()
                        return null
                    }
                }

                override fun onProgressUpdate(vararg values: Void?) {
                    super.onProgressUpdate(*values)
                }

                override fun onPostExecute(result: Bitmap?) {
                    super.onPostExecute(result)

                    if(result != null){
                        findViewById<ImageView>(R.id.imagePreview).setImageBitmap(result)
                    } else {
                        Toast.makeText(this@MainActivity,"다운로드 오류",Toast.LENGTH_LONG).show()
                    }
                }
            }
            asyncTask?.execute(editUrl.text.toString())
        }

    }


}