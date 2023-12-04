package com.example.favfilmsapp.movies

import com.example.favfilmsapp.Actor
import com.example.favfilmsapp.Movie
import com.example.favfilmsapp.R

object BreakfastData {
    private val breakfastScenes = listOf(
        R.drawable.breakfast_1,
        R.drawable.breakfast_2,
        R.drawable.breakfast_3,
        R.drawable.breakfast_4,
        R.drawable.breakfast_5,
        R.drawable.breakfast_6,
        R.drawable.breakfast_7,
        R.drawable.breakfast_8,
        R.drawable.breakfast_9,
        R.drawable.breakfast_10,
        R.drawable.breakfast_11,
        R.drawable.breakfast_12,
    )

    private val breakfastActors = listOf(
        Actor(
            name = "Audrey Hepburn",
            photo = R.drawable.breakfast_audrey
        ),
        Actor(
            name = "George Peppard",
            photo = R.drawable.breakfast_george
        ),
        Actor(
            name = "Buddy Ebsen",
            photo = R.drawable.breakfast_buddy
        ),
        Actor(
            name = "Patricia Neal",
            photo = R.drawable.breakfast_patricia
        ),
        Actor(
            name = "Mickey Rooney",
            photo = R.drawable.breakfast_mickey
        ),
        Actor(
            name = "Martin Balsam",
            photo = R.drawable.breakfast_martin
        )
    )

    private const val breakfastDescription =
        "A young New York socialite becomes interested in a young man who has moved into her apartment building, but her past threatens to get in the way."

    private val breakfastVideos = listOf<Int>()

    val breakfastMovie = Movie(
        title = "Breakfast at Tiffany's",
        poster = R.drawable.breakfast_poster,
        description = breakfastDescription,
        actors = breakfastActors,
        scenes = breakfastScenes,
        videos = breakfastVideos
    )
}