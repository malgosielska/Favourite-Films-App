package com.example.favfilmsapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.favfilmsapp.movies.MoviesData

class MovieViewModel : ViewModel() {

    val movies = MoviesData.movies

    var selectedTab = mutableStateOf<Int?>(0)

    val selectedMovie = mutableStateOf<Movie?>(null)
    val selectedPhoto = mutableStateOf<Int?>(null)

    fun changeSelectedMovie(movie: Movie) {
        selectedMovie.value = movie
    }

    fun changeSelectedPhoto(photo: Int) {
        selectedPhoto.value = photo
    }

    fun changeSelectedTab(n: Int) {
        selectedTab.value = n
    }
}