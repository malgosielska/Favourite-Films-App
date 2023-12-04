package com.example.favfilmsapp.movies

import com.example.favfilmsapp.Actor
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.R

object FriendsData {
    private val friendsScenes = listOf(
        R.drawable.friends_1,
        R.drawable.friends_2,
        R.drawable.friends_3,
        R.drawable.friends_4,
        R.drawable.friends_5,
        R.drawable.friends_6,
        R.drawable.friends_7,
        R.drawable.friends_8,
        R.drawable.friends_9,
        R.drawable.friends_10,
        R.drawable.friends_11,
        R.drawable.friends_12,
        R.drawable.friends_13,
        R.drawable.friends_14,
        R.drawable.friends_15,
    )

    private val friendsActors = listOf(
        Actor(
            name = "Jennifer Anniston",
            photo = R.drawable.friends_jen
        ),
        Actor(
            name = "Courtney Cox",
            photo = R.drawable.friends_courtney
        ),
        Actor(
            name = "Lisa Kudrow",
            photo = R.drawable.friends_lisa
        ),
        Actor(
            name = "Mat Leblanc",
            photo = R.drawable.friends_mat
        ),
        Actor(
            name = "Matthew Perry",
            photo = R.drawable.friends_matthew
        ),
        Actor(
            name = "David Schwimmer",
            photo = R.drawable.friends_david
        )
    )

    private const val friendsDescription =
        "Friends is a 90's Comedy TV show, based in Manhattan, about 6 friends who go through just about every life experience imaginable together"
    private val friendsVideos = listOf<Int>()

    val friendsMovie = Movie(
        title = "Friends",
        poster = R.drawable.friends_poster,
        description = friendsDescription,
        actors = friendsActors,
        scenes = friendsScenes,
        videos = friendsVideos

    )
}