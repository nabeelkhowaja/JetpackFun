package com.example.jetpackfun.repositories

import androidx.lifecycle.MutableLiveData
import com.example.jetpackfun.models.Location

object LocationRepository {

    val locations: MutableList<Location> = mutableListOf()

    fun getLocations(): MutableLiveData<List<Location>> {
        addLocations()
        var data: MutableLiveData<List<Location>> = MutableLiveData()
        data.value = locations
        return data
    }

    fun addLocations() {
        locations.add(
            Location(
                "https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg",
                "Karachi",
                24.4f,
                76.3f
            )
        )
        locations.add(
            Location(
                "https://c.tribune.com.pk/2016/03/1072545-mainsaddar-1459149578.jpg",
                "Karachi",
                24.4f,
                76.3f
            )
        )
    }
}