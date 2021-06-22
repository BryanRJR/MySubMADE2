package com.dicoding.core.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int = 0,

    @ColumnInfo(name = "movieTitle")
    var movieTitle: String? = null,

    @ColumnInfo(name = "movieDesc")
    var movieDesc: String? = null,

    @ColumnInfo(name = "moviePoster")
    var moviePoster: String? = null,

    @ColumnInfo(name = "movieBackdrop")
    var movieBackdrop: String? = null,

    @ColumnInfo(name = "movieDate")
    var movieDate: String? = null,

    @ColumnInfo(name = "movieFav")
    var movieFav: Boolean = false
)