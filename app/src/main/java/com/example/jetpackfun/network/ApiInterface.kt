package com.example.jetpackfun.network


import androidx.lifecycle.LiveData
import com.example.jetpackfun.models.Location
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(EndPoints.currentLocation)
    fun fetchCurrentLocation() : Deferred<Location>
}