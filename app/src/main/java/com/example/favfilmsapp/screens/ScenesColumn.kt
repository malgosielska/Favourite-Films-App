package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun PhotoItem(photo: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = photo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(shape = RectangleShape)
            .clickable(onClick = onClick)
            .padding(1.dp),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ScenesGrid(photos: List<Int>, onPhotoClicked: (Int) -> Unit) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        items(photos) { photo ->
            PhotoItem(photo) {
                onPhotoClicked(photo)
            }
        }
    }
}
