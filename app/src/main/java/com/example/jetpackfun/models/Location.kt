package com.example.jetpackfun.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Location(
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,
    var country_name: String,
    var latitude: Float,
    var longitude: Float,
    @SerializedName("location") @Ignore var image: Area

)
{
    constructor(): this(0, "", 0.0F, 0.0F,Area(""))
    data class Area(var country_flag: String)
}