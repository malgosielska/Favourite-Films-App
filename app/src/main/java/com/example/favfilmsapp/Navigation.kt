package com.example.favfilmsapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.favfilmsapp.screens.DisplayPhotoScreen
import com.example.favfilmsapp.screens.MainScreen
import com.example.favfilmsapp.screens.MovieDetailsScreen

const val MAIN_SCREEN_ROUTE = "main_screen"
const val DESCRIPTION_ROUTE = "description_screen"
const val PHOTO_ROUTE = "photo_screen"

@Composable
fun Navigation(myViewModel: MovieViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN_ROUTE
    ) {
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen(navController = navController, viewModel = myViewModel)
        }

        composable(
            route = DESCRIPTION_ROUTE,
        ) {
            MovieDetailsScreen(navController = navController, viewModel = myViewModel)
        }

        composable(
            route = PHOTO_ROUTE,
        ) {
            DisplayPhotoScreen(viewModel = myViewModel)
        }
    }
}


