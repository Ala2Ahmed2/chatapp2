package com.route.chatapp.ui.auth.fragments.register

import androidx.lifecycle.MutableLiveData
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.mis.route.chatapp.ui.ViewMessage
import com.mis.route.chatapp.ui.auth.fragments.login.LoginViewEvent
import com.mis.route.chatapp.ui.base.BaseViewModel
import com.mis.route.chatapp.ui.database.MyDatabase
import com.mis.route.chatapp.ui.database.User

class LoginViewModel: BaseViewModel(){
    val emailLiveData = MutableLiveData<String>()
    val emailError = MutableLiveData<String?>()
    val passwordLiveData = MutableLiveData<String>()
    val passwordError = MutableLiveData<String?>()
    val isLoading = MutableLiveData(false)
    val authService = Firebase.auth
    val events = MutableLiveData<LoginViewEvent>()

    fun login() {
        if (isLoading.value == true)return
        if (!validateInputs())return
        isLoading.value = true
        authService.signInWithEmailAndPassword(emailLiveData.value!!,
            passwordLiveData.value!!)
            .addOnCompleteListener { task->
                if (task.isSuccessful){
                    val user = task.result.user
                    getUserFromDataBase(user!!.uid)
                }else{
                    isLoading.value = false
                    viewMessage.value = ViewMessage(
                        message = task.exception?.localizedMessage?: "something went wrong"
                    )
                }
            }
        }

    private fun getUserFromDataBase(uid: String) {
        MyDatabase.getUserFromDB(uid){task->
            isLoading.value = false
            val user = task.result.toObject(User::class.java)
            if (task.isSuccessful && user != null){
                events.postValue(LoginViewEvent.NavigateToHome(user))
            }else{
                viewMessage.postValue(ViewMessage(
                    message = task.exception?.localizedMessage?:"",
                    posActionName = "ok"
                ))
            }
        }
    }

    fun onGoToRegisterClick(){
        events.postValue(LoginViewEvent.NavigateToRegister)
    }

    fun validateInputs(): Boolean {
        var isValid = true
        if (emailLiveData.value.isNullOrBlank()){
            emailError.value = "Please Enter Email"
            isValid = false
        }else{
            emailError.value = null
        }
        if (passwordLiveData.value.isNullOrBlank()){
            passwordError.value = "Please Enter Password"
            isValid = false
        }else if (passwordLiveData.value!!.length < 6){
            passwordError.value = "password must be at least 6 chars"
        }else{
            passwordError.value = null
        }
        return isValid
    }
}