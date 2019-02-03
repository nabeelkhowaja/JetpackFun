package com.example.jetpackfun.repositories

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.RestClient
import com.example.jetpackfun.network.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


object LocationRepository {

    suspend fun getLocation() : Result<Location>{
        return APIService.getLocation()
    }


}