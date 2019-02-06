package com.example.jetpackfun.repositories

import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.OnResponseReceivedListener

object LocationRepository {

    fun getLocation(listener: OnResponseReceivedListener) {
        APIService.getLocation(listener)
    }

}