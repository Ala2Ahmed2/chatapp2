package com.route.chatapp.ui.auth.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mis.route.chatapp.ui.auth.fragments.register.RegisterViewEvent
import com.mis.route.chatapp.ui.base.BaseFragment
import com.mis.route.chatapp.ui.database.User
import com.route.chatapp.R
import com.route.chatapp.databinding.FragmentRegisterBinding
import com.route.chatapp.ui.home.HomeFragment


class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_register

    override fun initViewModel(): RegisterViewModel =
        ViewModelProvider(this)[RegisterViewModel::class.java]

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.event.observe(viewLifecycleOwner,::onEventChange)
    }

    private fun onEventChange(event: RegisterViewEvent) {
        when(event){
            is RegisterViewEvent.NavigateToHome ->{
                navigateToHome(event.user)
            }
        }
    }

    private fun navigateToHome(user: User) {
        val action = RegisterFragmentDirections.actionRegisterFragmentToHomeFragment(user)
        findNavController().navigate(action)
    }

    private fun initView() {
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}