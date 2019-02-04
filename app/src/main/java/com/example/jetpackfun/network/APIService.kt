package com.example.jetpackfun.network

import com.example.jetpackfun.models.Location
import java.io.IOException

object APIService {
    suspend fun getLocation() : Result<Location>{
        try{
            val response = RestClient.restClient.fetchCurrentLocation().await()
        //    if (responseBody.)
                return Result.Success(response)
        //    return Result.Error(IOException("Error occurred during fetching location!"))
        }catch (e: Exception){
            return Result.Error(IOException("Unable to fetch location!"))
        }
    }
}