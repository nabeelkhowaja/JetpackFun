package com.example.jetpackfun.models.remote.network

import com.example.jetpackfun.models.datamodels.Location
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(EndPoints.currentLocation)
    fun fetchCurrentLocation(): Call<Location>
}