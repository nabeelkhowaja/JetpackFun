package com.example.jetpackfun.repositories

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.OnResponseReceivedListener


object LocationRepository {

    val locations: MutableList<Location> = mutableListOf()

    fun getLocations(): MutableLiveData<List<Location>> {
        locations.clear()
        addLocations()
        var data: MutableLiveData<List<Location>> = MutableLiveData()
        data.value = locations
        return data
    }

    fun addLocations() {
        getCurrentLocation()
//        locations.add(
//            Location(
//                Location.Area("https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg"),
//                "Karachi",
//                24.4f,
//                76.3f
//            )
//        )
//        locations.add(
//            Location(
//                Location.Area("https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg"),
//                "Karachi",
//                24.4f,
//                76.3f
//            )
//        )
    }

    fun getCurrentLocation(){

        APIService.fetchCurrentLocation(object : OnResponseReceivedListener{
            override fun onSuccessReceived(response: Any?) {
                locations.add(response as Location)
            }

            override fun onFailureReceived(errorMessage: String) {

            }

        })
    }
}