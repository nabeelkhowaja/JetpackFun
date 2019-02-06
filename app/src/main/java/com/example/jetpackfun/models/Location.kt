package com.example.jetpackfun.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("location") val image: Area, val country_name: String,
    val latitude: Float,
    val longitude: Float
) {
    data class Area(val country_flag: String)
}