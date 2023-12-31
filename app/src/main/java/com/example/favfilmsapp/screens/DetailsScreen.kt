package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.MovieViewModel
import com.example.favfilmsapp.PHOTO_ROUTE
import com.example.favfilmsapp.R
import com.example.favfilmsapp.ui.theme.Typography
import com.example.favfilmsapp.ui.theme.background


@Composable
fun DescriptionRow(movie: Movie, navController: NavController, viewModel: MovieViewModel) {

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_medium)))

    Row(
        modifier = Modifier
            .padding(all = dimensionResource(id = R.dimen.padding_small))
    )
    {
        Image(
            painter = painterResource(movie.poster),
            contentDescription = movie.title,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .clickable(onClick = {
                    viewModel.changeSelectedPhoto(movie.poster)
                    navController.navigate(PHOTO_ROUTE)
                })
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_large)))

        Text(
            text = movie.description,
            style = Typography.bodyMedium,
        )
    }
}


@Composable
fun SelectionTab(movie: Movie, navController: NavController, viewModel: MovieViewModel) {
    val selectedTabIndex = viewModel.selectedTab.value

    if (selectedTabIndex != null) {
        MediaTabs(selectedTabIndex = selectedTabIndex, updateTabIndex = { newTabIndex ->
            viewModel.changeSelectedTab(newTabIndex)
        })
    }

    when (selectedTabIndex) {
        0 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ScenesGrid(photos = movie.scenes, navController, viewModel)
            }
            viewModel.changeSelectedTab(0)
        }

        1 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ActorList(actors = movie.actors, navController, viewModel)
            }
            viewModel.changeSelectedTab(1)
        }

        2 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                VideosTab(videos = movie.videos)
            }
            viewModel.changeSelectedTab(2)
        }
    }
}

@Composable
fun MediaTabs(selectedTabIndex: Int, updateTabIndex: (Int) -> Unit) {
    TabRow(
        containerColor = Color.LightGray,
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
        Tab(
            selected = selectedTabIndex == 2,
            modifier = Modifier.background(background),
            onClick = { updateTabIndex(2) }) {
            Text(text = "Videos", style = Typography.bodyMedium)
        }
    }
}

@Composable
fun MovieDetailsScreen(navController: NavController, viewModel: MovieViewModel) {
    val selectedMovie = viewModel.selectedMovie.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        if (selectedMovie != null) {
            MyAppTopBar(title = selectedMovie.title)
            DescriptionRow(movie = selectedMovie, navController, viewModel)
            SelectionTab(movie = selectedMovie, navController, viewModel)
        }
    }
}
