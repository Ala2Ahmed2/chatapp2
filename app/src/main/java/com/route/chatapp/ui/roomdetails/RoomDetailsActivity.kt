package com.route.chatapp.ui.roomdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.chatapp.databinding.ActivityRoomDetailsBinding
import com.route.chatapp.ui.chat.ChatActivity

class RoomDetailsActivity : AppCompatActivity() {
    private var _binding: ActivityRoomDetailsBinding? = null
    private val binding: ActivityRoomDetailsBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRoomDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openRoomBtn.setOnClickListener { navigateToChat() }
    }

    private fun navigateToChat() {
        startActivity(Intent(this, ChatActivity::class.java))
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}