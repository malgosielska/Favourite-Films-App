package com.example.favfilmsapp.movies

import com.example.favfilmsapp.Actor
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.R

object GreaseData {
    private val greaseScenes = listOf(
        R.drawable.grease_1,
        R.drawable.grease_2,
        R.drawable.grease_3,
        R.drawable.grease_4,
        R.drawable.grease_5,
        R.drawable.grease_6,
        R.drawable.grease_7,
        R.drawable.grease_8,
        R.drawable.grease_9,
        R.drawable.grease_10,
        R.drawable.grease_11,
        R.drawable.grease_12,
    )

    private val greaseActors = listOf(
        Actor(
            name = "John Travolta",
            photo = R.drawable.grease_john
        ),
        Actor(
            name = "Olivia Newton-John",
            photo = R.drawable.grease_olivia
        ),
        Actor(
            name = "Stockard Channing",
            photo = R.drawable.grease_rizzo
        ),
        Actor(
            name = "Jeff Conaway",
            photo = R.drawable.grease_jeff
        ),
        Actor(
            name = "Didi Conn",
            photo = R.drawable.grease_didi
        )
    )

    private const val greaseDescription =
        "Good girl Sandy Olsson and greaser Danny Zuko fell in love over the summer. When they unexpectedly discover they're now in the same high school, will they be able to rekindle their romance?"

    private val greaseVideos = listOf(R.raw.grease_video_1, R.raw.grease_video_2, R.raw.grease_video_3)

    val greaseMovie = Movie(
        title = "Grease",
        poster = R.drawable.grease_poster,
        description = greaseDescription,
        actors = greaseActors,
        scenes = greaseScenes,
        videos = greaseVideos
    )
}