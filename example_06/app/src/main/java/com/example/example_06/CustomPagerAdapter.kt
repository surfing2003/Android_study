package com.example.example_06

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomPagerAdapter : RecyclerView.Adapter<Holder>(){
    var textList = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return textList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val text = textList[position]
        holder.setText(text)
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setText(text:String) {
        itemView.findViewById<TextView>(R.id.textView).text = text
    }
}
