package com.example.insta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.R
import com.example.insta.adapter.PostAdapter
import com.example.insta.adapter.StoryAdapter
import com.example.insta.data.PostData
import com.example.insta.data.StoryData
import com.example.insta.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var storyItemList :  ArrayList<StoryData>
    private lateinit var postItemList :  ArrayList<PostData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        fetchStoryItem()
        fetchPostItem()
        return binding.root

    }

    private fun fetchStoryItem() {
        val name = arrayOf("Ertugrul Ghazi",
            "Halima Sultan",
            "Osman Ghazi",
            "Bala Hatun",
            "Salman Khan",
            "Shahrukh khan")

        val image = arrayOf(R.drawable.ertugrul_ghazi,
            R.drawable.halima_sultan,
            R.drawable.osman_ghazi,
            R.drawable.bala_hatun,
            R.drawable.salman_khan,
            R.drawable.shahrukh_khan)

        storyItemList = ArrayList()

        for(index in image.indices){
            val userData = StoryData(image[index], name[index])
            storyItemList.add(userData)
        }

        binding.storyRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = StoryAdapter(requireContext(), storyItemList)
        }
    }

    private fun fetchPostItem() {
        val name = arrayOf("Ertugrul Ghazi",
            "Halima Sultan",
            "Osman Ghazi",
            "Bala Hatun",
            "Salman Khan",
            "Shahrukh khan")

        val image = arrayOf(R.drawable.ertugrul_ghazi,
            R.drawable.halima_sultan,
            R.drawable.osman_ghazi,
            R.drawable.bala_hatun,
            R.drawable.salman_khan,
            R.drawable.shahrukh_khan)

        val caption = arrayOf("Alhamdulillah for Everything",
            "Masha Allah",
            "fabulous",
            "Gorgeous",
            "Dashing",
            "Splendid")

        val like = arrayOf("50,786 likes",
            "39,112 likes",
            "41,554 likes",
            "35,331 likes",
            "55,987 likes",
            "51,665 likes")

        postItemList = ArrayList()

        for(index in name.indices) {
            val userData = PostData(name[index], image[index], like[index], caption[index])
            postItemList.add(userData)
        }

        binding.postRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PostAdapter(requireContext(), postItemList )
        }
    }

}