package com.margaritalashina.mytrainingprojectmobiledev

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentEmailConfirmationBinding
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentSignUpBinding

class EmailConfirmationFragment : BaseFragment(R.layout.fragment_email_confirmation) {

    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)

    private val viewModel: EmailConfirmationViewModel by viewModels()

}