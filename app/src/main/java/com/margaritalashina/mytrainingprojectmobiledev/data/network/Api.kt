package com.margaritalashina.mytrainingprojectmobiledev.data.network

import com.haroldadmin.cnradapter.NetworkResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.request.CreateProfileRequest
import com.margaritalashina.mytrainingprojectmobiledev.data.network.request.RefreshAuthTokensRequest
import com.margaritalashina.mytrainingprojectmobiledev.data.network.request.SignInWithEmailRequest
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.VerificationTokenResponse
import com.margaritalashina.mytrainingprojectmobiledev.data.network.response.error.*
import com.margaritalashina.mytrainingprojectmobiledev.entity.AuthTokens
import com.margaritalashina.mytrainingprojectmobiledev.entity.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.*


interface Api {

    @GET("users?per_page=10")
    suspend fun getUsers(): NetworkResponse<List<User>, Unit>

    @POST("auth/sign-in-email")
    suspend fun signInWithEmail(
        @Body request: SignInWithEmailRequest
    ): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse>

    @POST("auth/refresh-tokens")
    suspend fun refreshAuthTokens(
        @Body request: RefreshAuthTokensRequest
    ): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse>

    @POST("registration/verification-code/send")
    suspend fun sendRegistrationVerificationCode(
        @Query("email") email: String,
    ): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse>

    @POST("registration/verification-code/verify")
    suspend fun verifyRegistrationCode(
        @Query("code") code: String,
        @Query("email") email: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse>

    @PUT("registration/create-profile")
    suspend fun createProfile(
        @Body request: CreateProfileRequest
    ): NetworkResponse<AuthTokens, CreateProfileErrorResponse>
}


@JsonClass(generateAdapter = true)
data class GetUsersResponse(
    @Json(name = "data") val data: List<User>
)