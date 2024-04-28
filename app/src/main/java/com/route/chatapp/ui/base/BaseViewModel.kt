package com.mis.route.chatapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mis.route.chatapp.ui.ViewMessage

open class BaseViewModel : ViewModel() {
    val viewMessage = MutableLiveData<ViewMessage>()
}