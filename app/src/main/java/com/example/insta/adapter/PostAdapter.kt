package com.example.insta.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.R
import com.example.insta.data.PostData
import com.google.android.material.imageview.ShapeableImageView

class PostAdapter(private var context : Context, private var postItemList: ArrayList<PostData>) :
    RecyclerView.Adapter<PostAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userProfileImage : ShapeableImageView = itemView.findViewById(R.id.profile_image)
        val userName : TextView = itemView.findViewById(R.id.username)
        val userPost : ImageView = itemView.findViewById(R.id.post)
        val like : TextView = itemView.findViewById(R.id.likes)
        val userCaption : TextView = itemView.findViewById(R.id.caption)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postItemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPost = postItemList[position]
        holder.userProfileImage.setImageResource(currentPost.image)
        holder.userName.text = currentPost.name
        holder.userPost.setImageResource(currentPost.image)
        holder.like.text = currentPost.like
        holder.userCaption.text = currentPost.caption

    }
}