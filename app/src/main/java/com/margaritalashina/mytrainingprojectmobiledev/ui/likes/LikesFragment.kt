package com.margaritalashina.mytrainingprojectmobiledev.ui.likes

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentLikesBinding
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment

class LikesFragment : BaseFragment(R.layout.fragment_likes) {

    private val viewBinding by viewBinding(FragmentLikesBinding::bind)
    private val viewModel: LikesViewModel by viewModels()

}
