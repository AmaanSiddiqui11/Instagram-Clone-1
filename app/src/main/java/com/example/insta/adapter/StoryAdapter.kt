package com.example.insta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.R
import com.example.insta.data.StoryData

class StoryAdapter(private var context: Context, private var storyItemList : ArrayList<StoryData>) :
    RecyclerView.Adapter<StoryAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView = itemView.findViewById(R.id.story_image)
        val userName : TextView = itemView.findViewById(R.id.story_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.story_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return storyItemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentStory = storyItemList[position]
        holder.userImage.setImageResource(currentStory.image)
        holder.userName.text = currentStory.name
    }


}