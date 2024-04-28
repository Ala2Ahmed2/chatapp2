package com.mis.route.chatapp.ui.auth.fragments.login

import com.mis.route.chatapp.ui.database.User

sealed class LoginViewEvent {

    object NavigateToRegister : LoginViewEvent()

    class NavigateToHome(val user: User) : LoginViewEvent()
}