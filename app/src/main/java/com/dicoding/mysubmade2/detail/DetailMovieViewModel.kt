package com.dicoding.mysubmade2.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.domain.model.Movies
import com.dicoding.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovies(movies: Movies, newStatus:Boolean) =
        movieUseCase.setFavoriteMovies(movies, newStatus)
}