package com.example.example_01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return Holder(view)
        // 한줄로 해도 상관 X
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData[position]
        holder.setMemo(memo)
    }

}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setMemo(memo: Memo){
        itemView.findViewById<TextView>(R.id.textNo).text = "${memo.no}"
        itemView.findViewById<TextView>(R.id.Title).text = memo.title

        var sdf = SimpleDateFormat("yyyy/mm/dd")
        var formattedDate = sdf.format(memo.timestamp)
        itemView.findViewById<TextView>(R.id.textDate).text = formattedDate
    }
}