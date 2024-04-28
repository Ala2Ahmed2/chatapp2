package com.route.chatapp.ui.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.chatapp.databinding.ActivityChatBinding
import com.route.chatapp.ui.createroom.RoomCreationActivity

class ChatActivity : AppCompatActivity() {
    private var _binding: ActivityChatBinding? = null
    private val binding: ActivityChatBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sendRoomBtn.setOnClickListener { navigateToRoomCreation() }
    }

    private fun navigateToRoomCreation() {
        startActivity(Intent(this, RoomCreationActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}