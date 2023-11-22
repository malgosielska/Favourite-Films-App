package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.favfilmsapp.MovieViewModel

@Composable
fun DisplayPhotoScreen(viewModel: MovieViewModel) {
    val selectedPhoto = viewModel.selectedPhoto.value
    Row {
        if (selectedPhoto != null) {
            Image(
                painter = painterResource(id = selectedPhoto),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

    }
}