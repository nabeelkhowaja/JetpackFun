package com.example.jetpackfun.repositories

import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.Result

object LocationRepository {

    suspend fun getLocation() : Result<Location>{
        return APIService.getLocation()
    }

}