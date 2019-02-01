package com.example.jetpackfun.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    var restClient: ApiInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.ipstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        restClient = retrofit.create(ApiInterface::class.java)

    }
}