package com.example.jetpackfun.models

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName


data class Location(@SerializedName("location") val image: Area, val country_name: String, val latitude: Float, val longitude: Float){

    data class Area(val country_flag: String)
}