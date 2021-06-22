package com.dicoding.core.utils

import com.dicoding.core.domain.model.Movies
import com.dicoding.core.local.entity.MovieEntity
import com.dicoding.core.local.remote.MovieResponse

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie =
                MovieEntity(
                    movieId = it.id,
                    movieTitle = it.originalTitle,
                    movieDesc = it.overview,
                    moviePoster = it.posterPath,
                    movieBackdrop = it.backdrop_path,
                    movieDate = it.release_date,
                    movieFav = false
                )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movies> =
        input.map {
            Movies(
                movieId = it.movieId,
                movieTitle = it.movieTitle,
                movieDescription = it.movieDesc,
                moviePoster = it.moviePoster,
                movieBackdrop = it.movieBackdrop,
                movieDate = it.movieDate,
                movieFav = it.movieFav
            )
        }

    fun mapDomainToEntity(input: Movies) =
        MovieEntity(
            movieId = input.movieId,
            movieTitle = input.movieTitle,
            movieDesc = input.movieDescription,
            moviePoster = input.moviePoster,
            movieBackdrop = input.movieBackdrop,
            movieDate = input.movieDate,
            movieFav = input.movieFav
        )
}