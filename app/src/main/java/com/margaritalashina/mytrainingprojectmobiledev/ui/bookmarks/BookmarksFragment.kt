package com.margaritalashina.mytrainingprojectmobiledev.ui.bookmarks

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentBookmarksBinding
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment

class BookmarksFragment : BaseFragment(R.layout.fragment_bookmarks) {

    private val viewBinding by viewBinding(FragmentBookmarksBinding::bind)
    private val viewModel: BookmarksViewModel by viewModels()
}