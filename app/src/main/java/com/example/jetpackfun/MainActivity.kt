package com.example.jetpackfun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackfun.adapters.RecyclerViewAdapter
import com.example.jetpackfun.databinding.ActivityMainBinding
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.repositories.LocationRepository
import com.example.jetpackfun.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var adapter: RecyclerViewAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.mLocations.observe(this, Observer { adapter.notifyDataSetChanged() })

        initRecyclerView();

    }

    private fun initRecyclerView() {
        recyclerView = binding.recyclerView
        adapter = RecyclerViewAdapter(mainActivityViewModel.mLocations.value.orEmpty())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
