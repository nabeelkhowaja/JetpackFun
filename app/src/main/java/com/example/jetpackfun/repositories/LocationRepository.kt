package com.example.jetpackfun.repositories

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.jetpackfun.database.LocationDao
import com.example.jetpackfun.database.LocationDatabase
import com.example.jetpackfun.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.OnResponseReceivedListener

class LocationRepository(application: Application){

    var locationDao: LocationDao

    private var allLocation: LiveData<List<Location>>

    init {
        val database: LocationDatabase = LocationDatabase.getInstance(
            application.applicationContext
        )!!
        locationDao = database.locationDao()
        allLocation = locationDao.getAllLocation()
    }


    fun getLocation(listener: OnResponseReceivedListener) {
        APIService.getLocation(listener)
    }

    fun insert(location : Location) {
        insertAsyncTask(locationDao).execute(location)
    }

    companion object {
        private class insertAsyncTask internal constructor(private val mAsyncTaskDao: LocationDao) :
            AsyncTask<Location, Void, Void>() {

            override fun doInBackground(vararg params: Location): Void? {
                mAsyncTaskDao.insert(params[0])
                return null
            }
        }
    }


}