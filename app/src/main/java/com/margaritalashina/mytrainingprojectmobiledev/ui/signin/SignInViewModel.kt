package com.margaritalashina.mytrainingprojectmobiledev.ui.signin

import androidx.lifecycle.viewModelScope
import com.margaritalashina.mytrainingprojectmobiledev.repository.AuthRepository
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SignInViewModel : BaseViewModel() {

    fun signIn() {
        viewModelScope.launch {
            AuthRepository.signIn()
        }
    }
}