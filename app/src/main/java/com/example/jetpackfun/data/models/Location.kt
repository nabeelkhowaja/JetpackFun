package com.example.jetpackfun.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Location(
    @PrimaryKey(autoGenerate = true) val id:Int =0,
    val country_name: String,
    val latitude: Float,
    val longitude: Float,
    @SerializedName("location") @Embedded val image: Area
) {
    data class Area(val country_flag: String)
}