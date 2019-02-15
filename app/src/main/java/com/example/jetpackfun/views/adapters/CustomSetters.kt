package com.example.jetpackfun.views.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpackfun.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.getContext())
        .asBitmap()
        .apply(RequestOptions().placeholder(R.drawable.placeholder))
        .load(imageUrl)
        .into(view)
}