package com.margaritalashina.mytrainingprojectmobiledev.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileInformation(
    @Json(name = "firstName") val firstName : String,
    @Json(name = "lastName") val lastName : String,
    @Json(name = "userName") val userName : String,
    @Json(name = "email") val email : String,
    @Json(name = "password") val password : String
)