package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favfilmsapp.Movie


@Composable
fun MainScreen(movies: List<Movie>, onMovieClick: (Movie) -> Unit) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie = movie, onMovieClick)
        }
    }
}


@Composable
fun MovieCard(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable { onMovieClick(movie) }
    )
    {
        Image(
            painter = painterResource(movie.imageResource),
            contentDescription = movie.title,
            modifier = Modifier
                .size(140.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = movie.title,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(all = 14.dp),
            fontSize = 20.sp
        )
    }
}
