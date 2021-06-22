package com.dicoding.core.local.remote.api

import com.dicoding.core.local.remote.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = "c479eb3946af761fc5e4b130410185b6"
    ) : ListMovieResponse
}