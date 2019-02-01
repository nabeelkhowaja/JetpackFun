package com.example.jetpackfun.viewmodels

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.RestClient
import com.example.jetpackfun.repositories.LocationRepository
import java.util.logging.Handler

class MainActivityViewModel : ViewModel() {

    var mLocations: MutableLiveData<List<Location>> = MutableLiveData()
    val mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    init {
        mLocations = LocationRepository.getLocations()
        mIsUpdating.value = false
    }

    fun addNewLocation(location: Location) {
        mIsUpdating.value = true;
        doAsync(location).execute()
    }

    internal inner class doAsync(location: Location) : AsyncTask<Void, Void, Void>() {

        var location: Location

        init {
            this.location = location
        }

        override fun doInBackground(vararg params: Void?): Void? {
            Thread.sleep(2000)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            var currentLocations: MutableList<Location> = mLocations.value.orEmpty().toMutableList()
            currentLocations.add(location)
            mLocations.postValue(currentLocations)
            mIsUpdating.postValue(false)
        }
    }




}