package com.example.insta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.insta.R
import com.example.insta.adapter.ProfilePostAdapter
import com.example.insta.databinding.FragmentProfilePostBinding

class ProfilePostFragment : Fragment() {

    private lateinit var binding : FragmentProfilePostBinding
    private lateinit var profilePostList : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfilePostBinding.inflate(inflater, container, false)

        val postImages = arrayOf(R.drawable.ertugrul_ghazi,
            R.drawable.halima_sultan,
            R.drawable.osman_ghazi,
            R.drawable.bala_hatun,
            R.drawable.salman_khan,
            R.drawable.shahrukh_khan)

        profilePostList = ArrayList()

        for (index in postImages.indices) {
            val userPostImage = postImages[index]
            profilePostList.add(userPostImage)
        }

        binding.profilePostRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = ProfilePostAdapter(requireContext(), profilePostList)
        }

        return binding.root
    }

}