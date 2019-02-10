package com.example.jetpackfun.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Location(
    @PrimaryKey(autoGenerate = true) var id:Int =0,
    var country_name: String,
    var latitude: Float,
    var longitude: Float,
    @SerializedName("location") @Embedded var image: Area
) {
    data class Area(var country_flag: String)
}