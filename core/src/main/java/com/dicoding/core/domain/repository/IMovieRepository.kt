package com.dicoding.core.domain.repository

import com.dicoding.core.domain.model.Movies
import com.dicoding.core.local.Resource
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovies(): Flow<Resource<List<Movies>>>
    fun getFavoriteMovies(): Flow<List<Movies>>
    fun setFavoriteMovies(movies: Movies, state: Boolean)
}