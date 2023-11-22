package com.example.favfilmsapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.favfilmsapp.movies.MoviesData

class MovieViewModel : ViewModel() {

    val selectedMovie = mutableStateOf<Movie?>(null)
    val selectedPhoto = mutableStateOf<Int?>(null)
    val movies = MoviesData.movies

    fun changeSelectedMovie(movie: Movie) {
        selectedMovie.value = movie
    }

    fun changeSelectedPhoto(photo: Int) {
        selectedPhoto.value = photo
    }
}