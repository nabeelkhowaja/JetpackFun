package com.example.jetpackfun.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackfun.R
import com.example.jetpackfun.adapters.RecyclerViewAdapter
import com.example.jetpackfun.databinding.ActivityMainBinding
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.repositories.LocationRepository
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
        mMainActivityViewModel.mLocations.observe(this, Observer {
            mAdapter.update(mMainActivityViewModel.mLocations.value.orEmpty())
        })
        mMainActivityViewModel.mIsUpdating.observe(this, Observer {
            if (it) showProgressBar()
            else {
                hideProgressBar()
                //mRecyclerView.smoothScrollToPosition(mMainActivityViewModel.mLocations.value.orEmpty().size - 1)
            }
        })

        initRecyclerView();
        mBinding.floatingActionButton.setOnClickListener() {
            mMainActivityViewModel.addNewLocation(
                Location(
                    Location.Area(
                        "https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg"),
                        "Karachi",
                        24.4f,
                        76.3f
                    )
            )
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = RecyclerViewAdapter(mMainActivityViewModel.mLocations.value.orEmpty())
        mRecyclerView.adapter = mAdapter
    }

    private fun showProgressBar() {
        mBinding.progressBar1.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        mBinding.progressBar1.visibility = View.GONE
    }
}