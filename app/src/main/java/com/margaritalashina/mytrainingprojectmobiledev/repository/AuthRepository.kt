package com.margaritalashina.mytrainingprojectmobiledev.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// а можно создать его в App и сделать классом
object AuthRepository {

    private val _isAuthorizedFlow = MutableStateFlow(false)
    val isAuthorizedFlow = _isAuthorizedFlow.asStateFlow()

    suspend fun signIn() {
        _isAuthorizedFlow.emit(true)
    }
    suspend fun logOut() {
        _isAuthorizedFlow.emit(false)
    }
}