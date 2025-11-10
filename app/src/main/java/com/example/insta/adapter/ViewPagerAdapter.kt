package com.example.insta.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.insta.fragment.ProfileFragment
import com.example.insta.fragment.ProfilePostFragment
import com.example.insta.fragment.ProfileReelFragment
import com.example.insta.fragment.ProfileTagFragment

class ViewPagerAdapter(fa : ProfileFragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ProfilePostFragment()
            1 -> ProfileReelFragment()
            2 -> ProfileTagFragment()
            else -> ProfilePostFragment()
        }
    }
}