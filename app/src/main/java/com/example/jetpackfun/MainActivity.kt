package com.example.jetpackfun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpackfun.adapters.RecyclerViewAdapter
import com.example.jetpackfun.databinding.ActivityMainBinding
import com.example.jetpackfun.models.Location

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val locations : MutableList<Location> = mutableListOf()
        locations.add(Location("https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg","Karachi",24.4f,76.3f))
        locations.add(Location("https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg","Karachi",24.4f,76.3f))

        val recyclerView: RecyclerView = binding.recyclerView
        val adapter = RecyclerViewAdapter(locations)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
