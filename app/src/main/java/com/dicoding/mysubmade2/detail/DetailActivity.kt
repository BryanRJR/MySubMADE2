package com.dicoding.mysubmade2.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.core.domain.model.Movies
import com.dicoding.mysubmade2.R
import com.dicoding.mysubmade2.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovies = intent.getParcelableExtra<Movies>(EXTRA_DATA)
        showDetailTourism(detailMovies)
    }

    private fun showDetailTourism(detailMovies: Movies?) {
        detailMovies?.let {
            val imageUrl = detailMovies.movieBackdrop
            supportActionBar?.title = detailMovies.movieTitle
            binding.content.tvDetailDescription.text = detailMovies.movieDescription
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500$imageUrl")
                .into(binding.iviewDetailImg)

            var statusFavorite = detailMovies.movieFav
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovies(detailMovies, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white_24))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_24))
        }
    }
}