package com.example.favfilmsapp

data class Movie(
    val title: String,
    val imageResource: Int,
    val description: String,
    val scenes: List<Int>,
    val actors: List<Actor>
)