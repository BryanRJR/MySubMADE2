package com.dicoding.core.local.remote

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @field:SerializedName("results")
    val results: List<MovieResponse>,
)
