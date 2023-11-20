package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favfilmsapp.Actor
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.movies.GreaseData


@Composable
fun DescriptionRow(movie: Movie) {
    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .padding(all = 20.dp)
    )
    {
        Image(
            painter = painterResource(movie.imageResource),
            contentDescription = movie.title,
            modifier = Modifier
                .size(140.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = movie.description,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall,
            fontSize = 14.sp
        )
    }
}

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


@Composable
fun ActorCard(actor: Actor, onActorClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    )
    {
        Image(
            painter = painterResource(actor.photo),
            contentDescription = actor.name,
            modifier = Modifier
                .size(100.dp)
                .clickable { onActorClick(actor.photo) }
        )

        Text(
            text = actor.name,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(all = 10.dp),
            fontSize = 14.sp
        )
    }
}

@Composable
fun ActorList(actors: List<Actor>, onActorClicked: (Int) -> Unit) {
    LazyColumn {
        items(actors) { actor ->
            ActorCard(actor = actor) {
                onActorClicked(actor.photo)
            }
        }
    }
}

@Composable
fun ScenesAndActorsSection(movie: Movie, onPhotoClick: (Int) -> Unit) {
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
                ScenesGrid(photos = movie.scenes, onPhotoClick)
            }
        }

        1 -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ActorList(actors = movie.actors, onPhotoClick)
            }
        }
    }
}

@Composable
fun MediaTabs(selectedTabIndex: Int, updateTabIndex: (Int) -> Unit) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        Tab(selected = selectedTabIndex == 0, onClick = { updateTabIndex(0) }) {
            Text("Scenes")
        }
        Tab(selected = selectedTabIndex == 1, onClick = { updateTabIndex(1) }) {
            Text("Starring")
        }
    }
}

@Composable
fun MovieDetailsScreen(movie: Movie, onPhotoClick: (Int) -> Unit) {
    Column {
        DescriptionRow(movie = movie)
        ScenesAndActorsSection(movie = movie, onPhotoClick)
    }
}

@Preview
@Composable
fun MovieDetailsScreen() {
    MovieDetailsScreen(GreaseData.greaseMovie) {

    }
}
