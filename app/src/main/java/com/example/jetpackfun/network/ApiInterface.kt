package com.example.jetpackfun.network

import com.example.jetpackfun.models.Location
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiInterface {
    @GET(EndPoints.currentLocation)
    fun fetchCurrentLocation() : Deferred<Location>
}