package com.margaritalashina.mytrainingprojectmobiledev.ui.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.margaritalashina.mytrainingprojectmobiledev.BuildConfig
import com.margaritalashina.mytrainingprojectmobiledev.logBackstack
import com.margaritalashina.mytrainingprojectmobiledev.logFragmentHierarchy
import timber.log.Timber

open class BaseFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun onStart() {
        super.onStart()

        // каждый раз, когда мы будем переключаться с одного экрана на другой, будет происходить логирование

        if (BuildConfig.DEBUG) {
            val logTag = "NavigationInfo"
            logFragmentHierarchy(logTag)
            try {
                findNavController().logBackstack(logTag)
            } catch (error: IllegalStateException) {
                Timber.e(error)
            }
        }
    }
}