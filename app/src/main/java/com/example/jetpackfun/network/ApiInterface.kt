package com.example.jetpackfun.network

import com.example.jetpackfun.models.Location
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(EndPoints.currentLocation)
    fun fetchCurrentLocation(): Call<Location>
}