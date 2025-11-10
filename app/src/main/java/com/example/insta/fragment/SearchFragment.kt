package com.example.insta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.insta.R
import com.example.insta.adapter.SearchAdapter
import com.example.insta.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var searchList : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        fetchSearchItem()

        return binding.root
    }

    private fun fetchSearchItem() {
        val images = arrayOf(R.drawable.ertugrul_ghazi,
            R.drawable.halima_sultan,
            R.drawable.osman_ghazi,
            R.drawable.bala_hatun,
            R.drawable.salman_khan,
            R.drawable.shahrukh_khan)

        searchList = ArrayList()

        for(index in images.indices) {
            val img = images[index]
            searchList.add(img)
        }

        binding.searchRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = SearchAdapter(searchList)
        }
    }
}