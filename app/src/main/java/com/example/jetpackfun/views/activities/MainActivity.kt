package com.example.jetpackfun.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackfun.R
import com.example.jetpackfun.views.adapters.RecyclerViewAdapter
import com.example.jetpackfun.databinding.ActivityMainBinding
import com.example.jetpackfun.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    lateinit var mMainActivityViewModel: MainActivityViewModel

    lateinit var mAdapter: RecyclerViewAdapter
    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        setObservers()
        initRecyclerView();
        setListeners();
    }

    fun setObservers() {
        mMainActivityViewModel.getAllLocations().observe(this, Observer {
            mAdapter.update(mMainActivityViewModel.getAllLocations().value.orEmpty())
        })
        mMainActivityViewModel.mIsUpdating.observe(this, Observer {
            if (it) showProgressBar()
            else hideProgressBar()
        })
    }

    fun initRecyclerView() {
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = RecyclerViewAdapter(mMainActivityViewModel.getAllLocations().value.orEmpty())
        mRecyclerView.adapter = mAdapter
    }

    fun setListeners() { mBinding.floatingActionButton.setOnClickListener() { mMainActivityViewModel.addLocation() } }

    fun showProgressBar() { mBinding.progressBar1.visibility = View.VISIBLE }

    fun hideProgressBar() { mBinding.progressBar1.visibility = View.GONE }
}