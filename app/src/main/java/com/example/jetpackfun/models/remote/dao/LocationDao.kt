package com.example.jetpackfun.models.remote.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jetpackfun.models.datamodels.Location

@Dao
interface LocationDao {

    @Insert
    fun insert(location: Location)

    @Update
    fun update(location: Location)

    @Delete
    fun delete(location: Location)

    @Query("DELETE FROM Location")
    fun deleteAllLocation()

    @Query("SELECT * FROM Location")
    fun getAllLocation(): LiveData<List<Location>>

}