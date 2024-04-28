package com.route.chatapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.route.chatapp.R
import com.route.chatapp.databinding.ActivityAuthBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityAuthBinding? = null
    private val binding: ActivityAuthBinding get() = _binding!!

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavComponent()

    }

    private fun initNavComponent() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.auth_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}