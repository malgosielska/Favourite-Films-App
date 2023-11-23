package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.MovieViewModel
import com.example.favfilmsapp.PHOTO_ROUTE
import com.example.favfilmsapp.ui.theme.Typography
import com.example.favfilmsapp.ui.theme.background


@Composable
fun DescriptionRow(movie: Movie, navController: NavController, viewModel: MovieViewModel) {

    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .padding(all = 5.dp)
    )
    {
        Image(
            painter = painterResource(movie.poster),
            contentDescription = movie.title,
            modifier = Modifier
                .size(150.dp)
                .clickable(onClick = {
                    viewModel.changeSelectedPhoto(movie.poster)
                    navController.navigate(PHOTO_ROUTE)
                })
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = movie.description,
            style = Typography.bodyMedium,
        )
    }
}


@Composable
fun ScenesAndActorsSection(movie: Movie, navController: NavController, viewModel: MovieViewModel) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    MediaTabs(selectedTabIndex = selectedTabIndex, updateTabIndex = { newTabIndex ->
        selectedTabIndex = newTabIndex
    })

    when (selectedTabIndex) {
        0 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ScenesGrid(photos = movie.scenes, navController, viewModel)
            }
        }

        1 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ActorList(actors = movie.actors, navController, viewModel)
            }
        }
    }
}

@Composable
fun MediaTabs(selectedTabIndex: Int, updateTabIndex: (Int) -> Unit) {
    TabRow(
        containerColor = Color.LightGray, // Kolor tła całego TabRow
        selectedTabIndex = selectedTabIndex,
    ) {
        Tab(
            selected = selectedTabIndex == 0,
            modifier = Modifier.background(
                color = background
            ),
            onClick = { updateTabIndex(0) }) {
            Text("Scenes", style = Typography.bodyMedium)
        }
        Tab(
            selected = selectedTabIndex == 1,
            modifier = Modifier.background(background),
            onClick = { updateTabIndex(1) }) {
            Text(text = "Starring", style = Typography.bodyMedium)
        }
    }
}

@Composable
fun MovieDetailsScreen(navController: NavController, viewModel: MovieViewModel) {
    val selectedMovie = viewModel.selectedMovie.value
    Column {
        if (selectedMovie != null) {
            MyAppTopBar(title = selectedMovie.title)
            DescriptionRow(movie = selectedMovie, navController, viewModel)
            ScenesAndActorsSection(movie = selectedMovie, navController, viewModel)
        }
    }
}
