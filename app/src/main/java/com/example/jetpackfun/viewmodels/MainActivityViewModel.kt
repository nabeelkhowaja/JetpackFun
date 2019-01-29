package com.example.jetpackfun.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.repositories.LocationRepository

class MainActivityViewModel : ViewModel() {

    var mLocations : MutableLiveData<List<Location>> = MutableLiveData()
    init{
            mLocations = LocationRepository.getLocations()
    }
}