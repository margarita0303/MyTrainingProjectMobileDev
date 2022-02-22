package com.margaritalashina.mytrainingprojectmobiledev.ui.signin

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentSignInBinding
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController

class SignInFragment : BaseFragment(R.layout.fragment_sign_in) {

    private val viewBinding by viewBinding(FragmentSignInBinding::bind)
    private val viewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.signInButton.setOnClickListener {
            findNavController().popBackStack()
        }

        viewBinding.signInButton.setOnClickListener {
            viewModel.signIn()
        }
    }
}