package com.example.jetpackfun.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    var restClient: ApiInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.ipstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        restClient = retrofit.create(ApiInterface::class.java)

    }
}