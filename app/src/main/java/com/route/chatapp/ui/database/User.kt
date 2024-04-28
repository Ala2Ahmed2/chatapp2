package com.mis.route.chatapp.ui.database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val uid:String? = null,
    val userName:String? = null,
    val emil:String? = null
):Parcelable