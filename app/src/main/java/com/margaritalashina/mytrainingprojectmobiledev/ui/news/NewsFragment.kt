package com.margaritalashina.mytrainingprojectmobiledev.ui.news

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentNewsBinding
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val viewBinding by viewBinding(FragmentNewsBinding::bind)
    private val viewModel: NewsViewModel by viewModels()

}