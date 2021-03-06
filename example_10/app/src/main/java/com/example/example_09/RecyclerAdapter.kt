package com.example.example_09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var helper: RoomHelper? = null

    val listData = mutableListOf<RoomMemo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setRoomMemo(memo)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var mMemo: RoomMemo? = null

        init{
            itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {
                helper?.roomMemoDao()?.delete(mMemo!!)
                listData.remove(mMemo)
                notifyDataSetChanged()
            }
        }

        fun setRoomMemo(memo: RoomMemo){
            itemView.findViewById<TextView>(R.id.textNo).text = "${memo.no}"
            itemView.findViewById<TextView>(R.id.textContent).text = "${memo.content}"
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            itemView.findViewById<TextView>(R.id.textDatetime).text = "${sdf.format(memo.dateTime)}"
            this.mMemo = memo
        }
    }

}


