package com.margaritalashina.mytrainingprojectmobiledev.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: Long,
    @Json(name = "user_name") val userName: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "picture") val avatarUrl: String? = null,
    @Json(name = "about_me") val about: String? = null
)
