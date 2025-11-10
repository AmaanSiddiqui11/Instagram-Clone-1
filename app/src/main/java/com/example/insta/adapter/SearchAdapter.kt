package com.example.insta.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.databinding.SearchItemBinding

class SearchAdapter(private val searchItemList : ArrayList<Int>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return searchItemList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchItemList[position])
    }

    inner class SearchViewHolder(private val itemBinding : SearchItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(image : Int) {
            itemBinding.apply {
                searchImage.setImageResource(image)
            }
        }
    }

}