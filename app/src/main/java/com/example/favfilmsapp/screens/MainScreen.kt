package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.favfilmsapp.DESCRIPTION_ROUTE
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.MovieViewModel
import com.example.favfilmsapp.R
import com.example.favfilmsapp.ui.theme.Typography


@Composable
fun MainScreen(navController: NavController, viewModel: MovieViewModel) {
    Column {
        MyAppTopBar(title = "Vintage Vibes: Most Iconic Movies")
        LazyColumn {
            items(viewModel.movies) { movie ->
                MovieCard(movie = movie, navController, viewModel)
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie, navController: NavController, viewModel: MovieViewModel) {
    Row(
        modifier = Modifier
            .padding(all = dimensionResource(id = R.dimen.padding_medium))
            .clickable(onClick = {
                viewModel.changeSelectedMovie(movie)
                navController.navigate(DESCRIPTION_ROUTE)
            })
    )
    {
        Image(
            painter = painterResource(movie.poster),
            contentDescription = movie.title,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.huge_image))
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_medium)))

        Text(
            text = movie.title,
            style = Typography.bodyLarge,
            modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_normal)),
        )
    }
}
