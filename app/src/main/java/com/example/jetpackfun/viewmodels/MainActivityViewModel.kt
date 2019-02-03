package com.example.jetpackfun.viewmodels

import android.os.AsyncTask
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.RestClient
import com.example.jetpackfun.network.Result
import com.example.jetpackfun.repositories.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.HttpException
import java.util.logging.Handler

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