package com.example.jetpackfun.repositories

import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.OnResponseReceivedListener
import com.example.jetpackfun.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LocationRepository {

    fun getLocation(listener: OnResponseReceivedListener) {
        APIService.getLocation(listener)
    }

}