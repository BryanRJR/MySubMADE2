package com.dicoding.core.local

import com.dicoding.core.local.entity.MovieEntity
import com.dicoding.core.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovies()

    suspend fun insertMovies(movieList: List<MovieEntity>) = movieDao.insertMovies(movieList)

    fun setFavoriteMovies(movie: MovieEntity, newState: Boolean) {
        movie.movieFav = newState
        movieDao.updateFavoriteMovies(movie)
    }
}