package com.example.jetpackfun.viewmodels

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.OnResponseReceivedListener
import com.example.jetpackfun.repositories.LocationRepository

class MainActivityViewModel : ViewModel() {

    val TAG: String = "MainActivityViewModel"

    var mLocations: MutableLiveData<List<Location>> = MutableLiveData()
    val mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    init {
        mIsUpdating.value = false
        addLocation()
    }

    fun addLocation() {
        mIsUpdating.postValue(true)
        LocationRepository.getLocation(object : OnResponseReceivedListener {
            override fun onSuccessReceived(responseBody: Any?) {
                var currentLocations: MutableList<Location> = mLocations.value.orEmpty().toMutableList()
                currentLocations.add(responseBody as Location)
                mLocations.postValue(currentLocations)
                mIsUpdating.postValue(false)
            }

            override fun onFailureReceived(errorMessage: String?) {
                d(TAG, errorMessage)
                mIsUpdating.postValue(false)
            }
        })
    }
}