package com.example.insta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.R
import com.example.insta.adapter.HighlightsAdapter
import com.example.insta.adapter.ViewPagerAdapter
import com.example.insta.data.HighlightData
import com.example.insta.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    private lateinit var highlightItemList : ArrayList<HighlightData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        fetchHighlightsItem()
        fetchTabItem()

        return binding.root
    }

    private fun fetchHighlightsItem() {
        val name = arrayOf("Ertugrul Ghazi",
            "Halima Sultan",
            "Osman Ghazi",
            "Bala Hatun",
            "Salman Khan",
            "Shahrukh Khan")

        val image = arrayOf(R.drawable.ertugrul_ghazi,
            R.drawable.halima_sultan,
            R.drawable.osman_ghazi,
            R.drawable.bala_hatun,
            R.drawable.salman_khan,
            R.drawable.shahrukh_khan)

        highlightItemList = ArrayList()

        for(index in image.indices){
            val userData = HighlightData(image[index], name[index])
            highlightItemList.add(userData)
        }

        binding.highlightRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = HighlightsAdapter(requireContext(), highlightItemList)
        }
    }

    private fun fetchTabItem() {
        val tabLayout = binding.profileTabLayout
        val viewPager = binding.profileViewPager

        viewPager.apply {
            adapter = ViewPagerAdapter(this@ProfileFragment)
        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.setIcon(R.drawable.grid_icon)
                1 -> tab.setIcon(R.drawable.reel_icon)
                2 -> tab.setIcon(R.drawable.people_tag_icon)
            }
        }.attach()
    }
}