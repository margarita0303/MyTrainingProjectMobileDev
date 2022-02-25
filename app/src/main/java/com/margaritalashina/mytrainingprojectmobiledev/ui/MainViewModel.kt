package com.margaritalashina.mytrainingprojectmobiledev.ui

import com.margaritalashina.mytrainingprojectmobiledev.interactor.AuthInteractor
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : BaseViewModel() {
//    var isAuthorizedFlow: Flow<Boolean> = MutableStateFlow(false)

    suspend fun isAuthorizedFlow(): Flow<Boolean> =
        authInteractor.isAuthorized()
}