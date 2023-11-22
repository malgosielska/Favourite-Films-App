package com.example.favfilmsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favfilmsapp.Actor


@Composable
fun ActorCard(actor: Actor, onActorClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
    )
    {
        Image(
            painter = painterResource(actor.photo),
            contentDescription = actor.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .aspectRatio(1f)
                .clip(shape = RectangleShape)
                .clickable { onActorClick(actor.photo) }
        )

        Text(
            text = actor.name,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(all = 20.dp),
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