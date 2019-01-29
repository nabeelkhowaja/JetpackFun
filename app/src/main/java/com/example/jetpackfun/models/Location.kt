package com.example.jetpackfun.models

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


data class Location(val image: String, val name: String, val latitude: Float, val longitude: Float)