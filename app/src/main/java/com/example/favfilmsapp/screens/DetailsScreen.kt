package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favfilmsapp.Movie


@Composable
fun DescriptionRow(movie: Movie) {
    Spacer(modifier = Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .padding(all = 5.dp)
    )
    {
        Image(
            painter = painterResource(movie.imageResource),
            contentDescription = movie.title,
            modifier = Modifier
                .size(150.dp)
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
        Tab(selected = selectedTabIndex == 0, modifier = Modifier.background(
            color = Color(
                0xFFF9F9F9
            )
        ), onClick = { updateTabIndex(0) }) {
            Text("Scenes")
        }
        Tab(
            selected = selectedTabIndex == 1,
            modifier = Modifier.background(Color(0xFFF9F9F9)),
            onClick = { updateTabIndex(1) }) {
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
