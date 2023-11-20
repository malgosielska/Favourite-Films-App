package com.example.favfilmsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.favfilmsapp.movies.Movies
import com.example.favfilmsapp.ui.theme.FavFilmsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                FavFilmsAppTheme {
                    Navigation(Movies.movies)
                }
            }
        }
    }
}
