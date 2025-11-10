package com.example.insta.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.insta.R
import com.example.insta.adapter.ReelAdapter
import com.example.insta.data.ReelData
import com.example.insta.databinding.FragmentReelBinding
import kotlin.collections.ArrayList

class ReelFragment : Fragment() {

    private lateinit var binding: FragmentReelBinding
    private lateinit var reelAdapter: ReelAdapter
    private var reelList: List<ReelData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReelBinding.inflate(inflater, container, false)

        viewPager()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoPlayer = view.findViewById<ViewPager2>(R.id.reel_viewPager)

        val reelList = listOf(
            ReelData(
                videoUrl = "https://drive.google.com/uc?export=download&id=15reCYbzESGj4ycO5unBEl1fkxJeQzM3z",
                image = R.drawable.ertugrul_ghazi,
                name = "Ertugrul Ghazi",
                title ="Romantic reel",
                description = "Tum the ye khusboo hawa me thi..."
            ),

            ReelData(
                videoUrl = "https://drive.google.com/uc?export=download&id=1ofbGIavns0SjqcSPCvtwQgl9FGxPe7ho",
                image = R.drawable.halima_sultan,
                name = "Halima Sultan",
                title = "Old song reel",
                description = "Mujhse kisi ko pyar nahi, Awara hoon...",
            ),

            ReelData(
                videoUrl = "https://drive.google.com/uc?export=download&id=1M8AGJpcWwJlQE1Ec23jToN8TXnzM928G",
                image = R.drawable.osman_ghazi,
                name = "Osman Ghazi",
                title = "Surah Al-Imran",
                description = "Quran Shareef Hadees"
            ),

            ReelData(
                videoUrl = "https://drive.google.com/uc?export=download&id=1ux35gqq8hrKQL1Ey_LKsdfu6Tbfdk9Z4",
                image = R.drawable.bala_hatun,
                name = "Bala Hatun",
                title = "Support Palestine",
                description = "Iran women support palestine sold your gold jewellery"
            ),

            ReelData(
                videoUrl = "https://drive.google.com/uc?export=download&id=1vNQdtNtqIeDryzplLJ0p-Wjc1N8Xoxfy",
                image = R.drawable.salman_khan,
                name = "Salman Khan",
                title = "BestFriend k nakhrey",
                description = "Best friend funny line"
            ),

            ReelData(
                videoUrl = "https://drive.google.com/uc?export=download&id=1KiVW0bMo1MO30VCDZJBue5Lps8LhHy9a",
                image = R.drawable.shahrukh_khan,
                name = "Shahrukh Khan",
                title = "Smile",
                description = "Mine Smile"
            )
        )

        val videoAdapter = ReelAdapter(reelList)
        videoPlayer.adapter = videoAdapter
        videoPlayer.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("Reel Fragment", "Page selected: $position")
                // perform actions when a new page is selected
            }
        })
    }

    private fun viewPager() {
        binding.reelViewPager.apply {
            adapter = ReelAdapter(reelList)

            // Add onPageChangeCallback
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d("Reel Fragment", "Page selected: $position")
                    // perform action when a new page is selected
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Release all Exoplayer instances
        reelAdapter.releaseAllPlayer()
    }

}