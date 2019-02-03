package com.example.jetpackfun.network

import androidx.lifecycle.LiveData
import com.example.jetpackfun.models.Location
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


object APIService {
    suspend fun getLocation() : Result<Location>{
        val response : Location = RestClient.restClient.fetchCurrentLocation().await()
        try{
            //if (response.)
                return Result.Success(response)
        //    return Result.Error(IOException("Error occurred during fetching location!"))
        }catch (e: Exception){
            return Result.Error(IOException("Unable to fetch location!"))
        }
    }
}