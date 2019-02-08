package com.example.jetpackfun.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.OnResponseReceivedListener
import com.example.jetpackfun.repositories.LocationRepository

 class MainActivityViewModel(application: Application): AndroidViewModel(application) {

    val TAG: String = "MainActivityViewModel"

    var mLocations: MutableLiveData<List<Location>> = MutableLiveData()
    val mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()
    var locationRepository : LocationRepository = LocationRepository(application)

    init {
        mIsUpdating.value = false
    }

    fun addLocation() {
        mIsUpdating.postValue(true)
        locationRepository.getLocation(object : OnResponseReceivedListener {
            override fun onSuccessReceived(response: Any?) {
                var currentLocations: MutableList<Location> = mLocations.value.orEmpty().toMutableList()
                currentLocations.add(response as Location)
                mLocations.postValue(currentLocations)
                mIsUpdating.postValue(false)
                locationRepository.insert(response)
            }

            override fun onFailureReceived(errorMessage: String?) {
                d(TAG, errorMessage)
                mIsUpdating.postValue(false)
            }
        })
    }
}