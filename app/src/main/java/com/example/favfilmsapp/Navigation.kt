package com.example.favfilmsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.favfilmsapp.screens.MainScreen
import com.example.favfilmsapp.screens.MovieDetailsScreen

@Composable
fun Navigation(movies: List<Movie>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(movies = movies) { selectedMovie ->
                navController.navigate("movieDetails/${selectedMovie.title}")
            }
        }

        composable(
            route = "movieDetails/{movieTitle}",
            arguments = listOf(
                navArgument("movieTitle") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val movieTitle = backStackEntry.arguments?.getString("movieTitle") ?: ""
            val selectedMovie = movies.first { it.title == movieTitle }
            MovieDetailsScreen(selectedMovie)
        }
    }
}

