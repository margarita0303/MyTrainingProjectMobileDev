package com.margaritalashina.mytrainingprojectmobiledev.data.network

import com.haroldadmin.cnradapter.NetworkResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.request.CreateProfileRequest
import com.margaritalashina.mytrainingprojectmobiledev.data.network.request.RefreshAuthTokensRequest
import com.margaritalashina.mytrainingprojectmobiledev.data.network.request.SignInWithEmailRequest
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.VerificationTokenResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.error.*
import com.margaritalashina.mytrainingprojectmobiledev.entity.AuthTokens
import com.margaritalashina.mytrainingprojectmobiledev.entity.User

class MockApi : Api {
    private var isAuthorized = false

    override suspend fun getUsers(): NetworkResponse<List<User>, Unit> {
        return NetworkResponse.Success(
            body = listOf(
                User(
                    id = 0,
                    userName = "user_1",
                    avatarUrl = "https://mosaicart-home.ru/wp-content/uploads/2020/06/97-978328_avatar-icon-free-fa-user-circle-o.png",
                    firstName = "Lux",
                    lastName = "Dog"
                ),
                User(
                    id = 1,
                    userName = "user_2",
                    avatarUrl = "https://mosaicart-home.ru/wp-content/uploads/2020/06/97-978328_avatar-icon-free-fa-user-circle-o.png",
                    firstName = "New",
                    lastName = "Person"
                ),
                User(
                    id = 2,
                    userName = "user_3",
                    avatarUrl = "https://mosaicart-home.ru/wp-content/uploads/2020/06/97-978328_avatar-icon-free-fa-user-circle-o.png",
                    firstName = "Trisha",
                    lastName = "Trisha"
                ),
                User(
                    id = 3,
                    userName = "margarita0303",
                    avatarUrl = "https://mosaicart-home.ru/wp-content/uploads/2020/06/97-978328_avatar-icon-free-fa-user-circle-o.png",
                    firstName = "Margarita",
                    lastName = "Lashina"
                )
            ),
            code = 200
        )
    }

    override suspend fun signInWithEmail(request: SignInWithEmailRequest): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        return NetworkResponse.Success(
            AuthTokens(
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                accessTokenExpiration = 1640871771000,
                refreshTokenExpiration = 1640871771000,
            ),
            code = 200
        )
    }

    override suspend fun refreshAuthTokens(request: RefreshAuthTokensRequest): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun sendRegistrationVerificationCode(email: String): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        return NetworkResponse.Success(
            body = Unit,
            code = 200
        )
    }

    override suspend fun verifyRegistrationCode(
        code: String,
        email: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        return NetworkResponse.Success(
            body = VerificationTokenResponse("OK"),
            code = 200
        )
    }

    override suspend fun createProfile(request: CreateProfileRequest): NetworkResponse<AuthTokens, CreateProfileErrorResponse> {
        if (isAuthorized) {
            return NetworkResponse.Success(
                AuthTokens(
                    accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                    refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                    accessTokenExpiration = 1640871771000,
                    refreshTokenExpiration = 1640871771000,
                ),
                code = 200
            )
        }
        else {
            isAuthorized = true
            return NetworkResponse.ServerError<CreateProfileErrorResponse>(
                body = null,
                code = 400
            )
        }
    }
}