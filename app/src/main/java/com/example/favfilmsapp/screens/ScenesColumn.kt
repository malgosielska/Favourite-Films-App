package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.favfilmsapp.MovieViewModel
import com.example.favfilmsapp.PHOTO_ROUTE
import com.example.favfilmsapp.R


@Composable
fun PhotoItem(photo: Int, navController: NavController, viewModel: MovieViewModel) {
    Image(
        painter = painterResource(id = photo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(shape = RectangleShape)
            .clickable(onClick = {
                viewModel.changeSelectedPhoto(photo)
                navController.navigate(PHOTO_ROUTE)
            }
            )
            .padding(dimensionResource(id = R.dimen.padding_tiny)),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ScenesGrid(photos: List<Int>, navController: NavController, viewModel: MovieViewModel) {

    LazyVerticalGrid (
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
            .height(600.dp)
    ) {
        items(photos) { photo ->
            PhotoItem(photo, navController, viewModel)
        }
    }
}
