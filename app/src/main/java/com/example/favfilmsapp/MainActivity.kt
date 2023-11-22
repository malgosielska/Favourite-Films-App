package com.example.favfilmsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.favfilmsapp.movies.MoviesData
import com.example.favfilmsapp.ui.theme.FavFilmsAppTheme

// todo -> maybe add more scenes and films??
// todo -> change colors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                FavFilmsAppTheme {
                    Navigation()
                }
            }
        }
    }
}
