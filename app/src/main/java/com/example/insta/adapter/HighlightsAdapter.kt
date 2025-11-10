package com.example.insta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.R
import com.example.insta.data.HighlightData

class HighlightsAdapter(private var context : Context, private var highlightItemList : ArrayList<HighlightData>) :
    RecyclerView.Adapter<HighlightsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val highlightImage : ImageView = itemView.findViewById(R.id.highlight_image)
        val highlightName : TextView = itemView.findViewById(R.id.highlight_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profile_highlights_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return highlightItemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentHighlight = highlightItemList[position]
        holder.highlightImage.setImageResource(currentHighlight.image)
        holder.highlightName.text = currentHighlight.name
    }
}