package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.Movies
import com.dicoding.core.domain.repository.IMovieRepository


class MovieInteractor(private val movieRepo: IMovieRepository): MovieUseCase {

    override fun getAllMovies() = movieRepo.getAllMovies()
    override fun getFavoriteMovies() = movieRepo.getFavoriteMovies()
    override fun setFavoriteMovies(movies: Movies, state: Boolean) = movieRepo.setFavoriteMovies(movies, state)

}