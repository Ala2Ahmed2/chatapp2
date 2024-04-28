package com.route.chatapp.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mis.route.chatapp.ui.home.fragments.allrooms.AllRoomsFragment
import com.mis.route.chatapp.ui.home.fragments.myrooms.MyRoomsFragment

const val PAGES_NUM = 2

class RoomsViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = PAGES_NUM

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> MyRoomsFragment()
            else -> AllRoomsFragment()
        }
        return fragment
    }
}