package com.dicoding.mysubmade2.di

import com.dicoding.core.domain.usecase.MovieInteractor
import com.dicoding.core.domain.usecase.MovieUseCase
import com.dicoding.mysubmade2.detail.DetailMovieViewModel
import com.dicoding.mysubmade2.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}