package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.favfilmsapp.Actor
import com.example.favfilmsapp.MovieViewModel
import com.example.favfilmsapp.PHOTO_ROUTE
import com.example.favfilmsapp.R
import com.example.favfilmsapp.ui.theme.Typography


@Composable
fun ActorCard(actor: Actor, navController: NavController, viewModel: MovieViewModel) {
    Row(
        modifier = Modifier
            .padding(all = dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
    )
    {
        Image(
            painter = painterResource(actor.photo),
            contentDescription = actor.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .aspectRatio(1f)
                .clip(shape = RectangleShape)
                .clickable(onClick = {
                    viewModel.changeSelectedPhoto(actor.photo)
                    navController.navigate(PHOTO_ROUTE)
                })
        )

        Text(
            text = actor.name,
            style = Typography.bodyMedium,
            modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_large)),
        )
    }
}

@Composable
fun ActorList(actors: List<Actor>, navController: NavController, viewModel: MovieViewModel) {
    LazyColumn(modifier = Modifier.height(500.dp)) {
        items(actors) { actor ->
            ActorCard(actor = actor, navController, viewModel)
        }
    }
}