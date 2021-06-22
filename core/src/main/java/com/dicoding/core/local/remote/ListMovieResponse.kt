package com.dicoding.core.local.remote

import com.google.gson.annotations.SerializedName
import java.util.*

data class ListMovieResponse(
    @field:SerializedName("results")
    val results: List<MovieResponse>,
)
