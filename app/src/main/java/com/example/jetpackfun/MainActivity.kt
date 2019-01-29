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


        var locations: MutableList<Location> = mutableListOf(Location("https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg","Karachi",24.4f,76.3f))

        val recyclerView: RecyclerView = binding.recyclerView
        val adapter: RecyclerViewAdapter = RecyclerViewAdapter(locations)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter



//        binding.button2.setOnClickListener {
//            if (binding.button2.text.equals("Show")) {
//                binding.button2.text = "Hide"
//                val location = Location("Karachi", 24.2f, 76.4f)
//                binding.setVariable(BR.location, location)
//                binding.executePendingBindings()
//            } else {
//                binding.button2.setText("Show")
//            }
//            toggleVisibility(binding.textView)
//            toggleVisibility(binding.textView2)
//            toggleVisibility(binding.textView3)
//        }
    }
}
