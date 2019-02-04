package com.example.jetpackfun.viewmodels

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.Result
import com.example.jetpackfun.repositories.LocationRepository
import com.example.jetpackfun.views.activities.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    var mLocations: MutableLiveData<List<Location>> = MutableLiveData()
    val mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    init {
        mIsUpdating.value = false
        addLocation()
    }

    fun addLocation() {
        GlobalScope.launch(Dispatchers.Main) {
            mIsUpdating.postValue(true)
            val result = LocationRepository.getLocation()
            when (result){
                is Result.Success -> {
                    var currentLocations : MutableList<Location> = mLocations.value.orEmpty().toMutableList()
                    currentLocations.add(result.data)
                    mLocations.postValue(currentLocations)
                    mIsUpdating.postValue(false)
                }
            }

        }

    }
}