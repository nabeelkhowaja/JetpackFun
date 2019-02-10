package com.example.jetpackfun.data.repositories

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.jetpackfun.data.JetpackDatabase
import com.example.jetpackfun.data.LocationDao
import com.example.jetpackfun.data.models.Location
import com.example.jetpackfun.network.APIService
import com.example.jetpackfun.network.OnResponseReceivedListener

class LocationRepository(application: Application){

    var locationDao: LocationDao
    private var allLocation: LiveData<List<Location>>

    init {
        val database: JetpackDatabase = JetpackDatabase.getInstance(
            application.applicationContext
        )!!
        locationDao = database.locationDao()
        allLocation = locationDao.getAllLocation()
    }

    fun getLocation(listener: OnResponseReceivedListener) { APIService.getLocation(listener) }

    fun insert(location : Location) { insertAsyncTask(locationDao).execute(location) }

    fun getAllLocations() : LiveData<List<Location>>{ return allLocation }

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