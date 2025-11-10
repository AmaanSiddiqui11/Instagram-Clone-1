package com.example.insta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.R

class ProfilePostAdapter(private val context : Context, private val profilePostList: ArrayList<Int>) : RecyclerView.Adapter<ProfilePostAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.profile_post_img1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profile_post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return profilePostList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPost = profilePostList[position]
        holder.image.setImageResource(currentPost)
    }
}