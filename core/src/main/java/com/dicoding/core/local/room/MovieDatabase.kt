package com.dicoding.core.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.dicoding.core.local.entity.MovieEntity::class], version = 3, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}