package com.margaritalashina.mytrainingprojectmobiledev.ui

import com.margaritalashina.mytrainingprojectmobiledev.repository.AuthRepository
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : BaseViewModel() {

    val isAuthorizedFlow: Flow<Boolean> = AuthRepository.isAuthorizedFlow
}