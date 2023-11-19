package com.example.favfilmsapp

object SampleData {
    private val greaseActors = listOf(
        Actor(
            name = "John Travolta",
            photo = R.drawable.john_travolta
        ),
        Actor(
            name = "John Travolta",
            photo = R.drawable.john_travolta
        ),
        Actor(
            name = "John Travolta",
            photo = R.drawable.john_travolta
        ),
        Actor(
            name = "John Travolta",
            photo = R.drawable.john_travolta
        )
    )

    val movies = listOf(
        Movie(
            title = "that is my title 1",
            imageResource = R.drawable.title,
            description = "Whether you're preparing for your first job interview or aiming to upskill in this ever-evolving tech landscape, GeeksforGeeks Courses are your key to success. We provide top-quality content at affordable prices, all geared towards accelerating your growth in a time-bound manner. Don't miss out - check it out now!",
            actors = greaseActors,
            scenes = listOf(R.drawable.grease_1, R.drawable.grease_1, R.drawable.grease_1, R.drawable.grease_1, R.drawable.grease_1, R.drawable.grease_1, R.drawable.grease_1)
        ),
        Movie(
            title = "that is my title 2",
            imageResource = R.drawable.title,
            description = "",
            actors = listOf(),
            scenes = listOf()
        ),
        Movie(
            title = "that is my title 3",
            imageResource = R.drawable.title,
            description = "",
            actors = listOf(),
            scenes = listOf()
        ),
        Movie(
            title = "that is my title 4",
            imageResource = R.drawable.title,
            description = "",
            actors = listOf(),
            scenes = listOf()
        )
    )
}