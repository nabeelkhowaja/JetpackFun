package com.example.jetpackfun.network

import com.example.jetpackfun.models.Location
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

object APIService{

    fun getLocation(listener: OnResponseReceivedListener) {
        RestClient.restClient.fetchCurrentLocation().enqueue(object : Callback<Location> {
            override fun onResponse(call: Call<Location>, response: Response<Location>) {
                listener.onSuccessReceived(response.body())
            }
            override fun onFailure(call: Call<Location>, t: Throwable) {
                listener.onFailureReceived(t.message)
            }
        })
    }
}