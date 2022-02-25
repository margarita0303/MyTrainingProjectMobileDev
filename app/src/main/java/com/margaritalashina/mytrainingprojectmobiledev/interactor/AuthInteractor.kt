package com.margaritalashina.mytrainingprojectmobiledev.interactor

import com.haroldadmin.cnradapter.NetworkResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.VerificationTokenResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.error.CreateProfileErrorResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.error.SendRegistrationVerificationCodeErrorResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.error.SignInWithEmailErrorResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.error.VerifyRegistrationCodeErrorResponse
import com.margaritalashina.mytrainingprojectmobiledev.entity.AuthTokens
import com.margaritalashina.mytrainingprojectmobiledev.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject


// интерактор реализует какой-то сценарий использования приложения
class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend fun isAuthorized(): Flow<Boolean> =
        authRepository.isAuthorizedFlow()

    suspend fun signInWithEmail(email: String, password: String): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        val response = authRepository.generateAuthTokensByEmail(email, password)
        when (response) {
            is NetworkResponse.Success -> {
                authRepository.saveAuthTokens(response.body)
            }
            is NetworkResponse.Error -> {
                Timber.e(response.error)
            }
        }
        return response
    }

    suspend fun createProfile(
        email: String,
        verificationToken: String,
        firstName: String,
        lastName: String,
        nickName: String,
        password: String
    ): NetworkResponse<AuthTokens, CreateProfileErrorResponse> {
        val response = authRepository.generateAuthTokensByEmailAndPersonalInfo(
            email,
            verificationToken,
            firstName,
            lastName,
            nickName,
            password
        )
        when (response) {
            is NetworkResponse.Success -> {
                authRepository.saveAuthTokens(response.body)
            }
            is NetworkResponse.Error -> {
                Timber.e(response.error)
            }
            else -> {
                // TODO: обработать случай
            }
        }
        return response
    }

    suspend fun sendRegistrationVerificationCode(
        email: String
    ): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        val response = authRepository.sendRegistrationVerificationCode(email)
        when (response) {
            is NetworkResponse.Success -> {
                // do smth
            }
            is NetworkResponse.Error -> {
                Timber.e(response.error)
            }
            else -> {
                // TODO: обработать случай
            }
        }
        return response
    }

    suspend fun verifyRegistrationCode(
        email: String,
        code: String
    ) : NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        val response = authRepository.verifyRegistrationCode(email, code)
        when (response) {
            is NetworkResponse.Success -> {
                // TODO: добавить логику
            }
            is NetworkResponse.Error -> {
                Timber.e(response.error)
            }
            else -> {
                // TODO: обработать случай
            }
        }
        return response
    }

    suspend fun logout() {
        authRepository.saveAuthTokens(null)
    }
}