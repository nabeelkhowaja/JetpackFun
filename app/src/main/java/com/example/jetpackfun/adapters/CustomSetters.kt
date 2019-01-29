package com.example.jetpackfun.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.getContext())
        .asBitmap()
        .load(imageUrl)
        .into(view)
}