package com.margaritalashina.mytrainingprojectmobiledev.ui.confirmation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentEmailConfirmationBinding
import dev.chrisbanes.insetter.applyInsetter

class EmailConfirmationFragment : BaseFragment(R.layout.fragment_email_confirmation) {

    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)

    private val viewModel: EmailConfirmationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.backButton.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.confirmVerificationCodeButton.applyInsetter {
            type(navigationBars = true) { margin() }
        }
        viewBinding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}