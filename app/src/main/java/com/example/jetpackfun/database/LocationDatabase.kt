package com.example.jetpackfun.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackfun.models.Location


@Database(entities = [Location::class], version = 1, exportSchema = false)
abstract class LocationDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        private var instance: LocationDatabase? = null

        fun getInstance(context: Context): LocationDatabase? {
            if (instance == null) {
                synchronized(LocationDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocationDatabase::class.java, "location_database"
                    )
                        .fallbackToDestructiveMigration() // when version increments, it migrates (deletes db and creates new) - else it crashes
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

    }


}