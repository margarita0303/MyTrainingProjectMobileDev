package com.margaritalashina.mytrainingprojectmobiledev.ui.confirmation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentEmailConfirmationBinding
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment
import dev.chrisbanes.insetter.applyInsetter

class EmailConfirmationFragment : BaseFragment(R.layout.fragment_email_confirmation) {

    private val viewBinding by viewBinding(FragmentEmailConfirmationBinding::bind)

    private val viewModel: EmailConfirmationViewModel by viewModels()

    private val millisRunning : Long = 10000
    private val countDownInterval : Long= 1000
    private val codeTimer = timer()

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

        viewBinding.sendInformation.isEnabled = false

        viewBinding.sendAgainClickableText.setOnClickListener {
            Toast.makeText(requireContext(), "Код отправлен", Toast.LENGTH_SHORT).show()
            viewBinding.sendInformation.isEnabled = false
            codeTimer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        codeTimer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        codeTimer.cancel()
    }

    private fun timer() : CountDownTimer {
        return object: CountDownTimer(millisRunning,countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                viewBinding.sendAgainClickableText.isVisible = true
                val secondsUntilFinished = (millisUntilFinished/1000).toString()
                viewBinding.sendAgainClickableText.text = "Повторный код будет отправлен через: $secondsUntilFinished с"
            }

            override fun onFinish() {
                viewBinding.sendAgainClickableText.isEnabled = true
                viewBinding.sendAgainClickableText.isVisible = false
            }
        }
    }


}