package com.example.jetpackfun.models.remote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackfun.models.datamodels.Location
import com.example.jetpackfun.models.remote.dao.LocationDao

@Database(entities = [Location::class], version = 1, exportSchema = false)
abstract class JetpackDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        private var instance: JetpackDatabase? = null

        fun getInstance(context: Context): JetpackDatabase? {
            if (instance == null) {
                synchronized(JetpackDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JetpackDatabase::class.java, "jetpack_database"
                    )
                        .fallbackToDestructiveMigration() // when version increments, it migrates (deletes db and creates new) - else it crashes
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() { instance = null }

    }
}