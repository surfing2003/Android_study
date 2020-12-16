package com.example.example_09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<Holder>() {
    val listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setMemo(memo: Memo){
        itemView.findViewById<TextView>(R.id.textNo).text = "${memo.no}"
        itemView.findViewById<TextView>(R.id.textContent).text = "${memo.content}"
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
        itemView.findViewById<TextView>(R.id.textDatetime).text = "${sdf.format(memo.datetime)}"
    }
}

