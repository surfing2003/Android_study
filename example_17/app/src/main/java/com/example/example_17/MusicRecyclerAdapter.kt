package com.example.example_17

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class MusicRecyclerAdapter : RecyclerView.Adapter<MusicRecyclerAdapter.Holder>() {

    var musicList = mutableListOf<Music>()
    var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList[position]
        holder.setMusic(music)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var musicUri: Uri? =  null

        init {
            itemView.setOnClickListener{
                if (mediaPlayer != null){
                    mediaPlayer?.release()
                    mediaPlayer = null
                }
                mediaPlayer = MediaPlayer.create(itemView.context, musicUri)
                mediaPlayer?.start()
            }
        }

        fun setMusic(music: Music){
            itemView.findViewById<ImageView>(R.id.imageAlbum).setImageURI(music.getAlbumUri())
            itemView.findViewById<TextView>(R.id.textArtist).text = music.artist
            itemView.findViewById<TextView>(R.id.textTitle).text = music.title

            val duration = SimpleDateFormat("mm:ss").format(music.duration)
            itemView.findViewById<TextView>(R.id.textDuration).text = duration

            this.musicUri = music.getMusicUri()
        }
    }

}


