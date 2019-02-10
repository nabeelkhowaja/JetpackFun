package com.example.jetpackfun.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpackfun.data.models.Location
import com.example.jetpackfun.network.OnResponseReceivedListener
import com.example.jetpackfun.data.repositories.LocationRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    val TAG: String = "MainActivityViewModel"

    val mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()
    val locationRepository: LocationRepository = LocationRepository(application)
    private val allLocations: LiveData<List<Location>> = locationRepository.getAllLocations()

    init {
        mIsUpdating.value = false
    }

    fun addLocation() {
        mIsUpdating.value = true
        locationRepository.getLocation(object : OnResponseReceivedListener {
            override fun onSuccessReceived(response: Any?) {
                mIsUpdating.postValue(false)
                locationRepository.insert(response as Location)
            }

            override fun onFailureReceived(errorMessage: String?) {
                d(TAG, errorMessage)
                mIsUpdating.postValue(false)
            }
        })
    }

    fun getAllLocations(): LiveData<List<Location>>{
        return allLocations
    }
}