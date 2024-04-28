package com.route.chatapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.mis.route.chatapp.ui.base.BaseFragment
import com.mis.route.chatapp.ui.home.HomeViewModel
import com.route.chatapp.R
import com.route.chatapp.databinding.ActivityHomeBinding
import com.route.chatapp.ui.home.adapter.RoomsViewPagerAdapter
import com.route.chatapp.ui.roomdetails.RoomDetailsActivity

class HomeFragment : BaseFragment<ActivityHomeBinding, HomeViewModel>() {

    override fun initViewModel(): HomeViewModel =
        ViewModelProvider(this)[HomeViewModel::class.java]

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRoomsViewPager()
        binding.addRoomBtn.setOnClickListener { navigateToRoomDetails() }
    }

    private fun navigateToRoomDetails() {
        startActivity(Intent(activity, RoomDetailsActivity::class.java))
    }

    private fun initRoomsViewPager() {
        val adapter = RoomsViewPagerAdapter(requireActivity())
        binding.roomsViewPager.adapter = adapter
        TabLayoutMediator(binding.roomsTabLayout, binding.roomsViewPager) { tab, position ->
            val tabTitles = resources?.getStringArray(R.array.rooms_fragments_titles) ?: emptyArray()
            tab.text = tabTitles[position]
        }.attach()
    }
}