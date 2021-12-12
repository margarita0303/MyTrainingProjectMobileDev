package com.margaritalashina.mytrainingprojectmobiledev

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.GET

interface Api {

    // библиотека retrofit на этапе компиляции обнаружит файл с аннотацией
    // и сгенерирует реализацию метода

    @GET("users")
    suspend fun getUsers(): GetUsersResponse
}

@JsonClass(generateAdapter = true)
data class GetUsersResponse(
    @Json(name = "data") val data: List<User>
)