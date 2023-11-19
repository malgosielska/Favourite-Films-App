package com.example.favfilmsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.favfilmsapp.ui.theme.FavFilmsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                FavFilmsAppTheme {
                    val movies = SampleData.movies
                    Navigation(movies)
                }
            }
        }
    }
}

@Composable
fun Navigation(movies: List<Movie>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(movies = movies) { selectedMovie ->
                navController.navigate("movieDetails/${selectedMovie.title}")
            }
        }

        composable(
            route = "movieDetails/{movieTitle}",
            arguments = listOf(
                navArgument("movieTitle") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val movieTitle = backStackEntry.arguments?.getString("movieTitle") ?: ""
            val selectedMovie = movies.first { it.title == movieTitle }
            MovieDetails(selectedMovie)
        }
    }
}


@Composable
fun MainScreen(movies: List<Movie>, onMovieClick: (Movie) -> Unit) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie = movie, onMovieClick)
        }
    }
}


@Composable
fun MovieCard(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable { onMovieClick(movie) }
    )
    {
        Image(
            painter = painterResource(movie.imageResource),
            contentDescription = movie.title,
            modifier = Modifier
                .size(140.dp)
                .border(1.5.dp, MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = movie.title,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(all = 14.dp),
            fontSize = 20.sp
        )
    }
}


@Composable
fun ScenesGrid(photos: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        items(photos) { photo ->
            PhotoItem(photo)
        }
    }
}

@Composable
fun PhotoItem(photo: Int) {
    Image(
        painter = painterResource(id = photo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(shape = RectangleShape)
            .padding(1.dp),
        contentScale = ContentScale.Crop,
    )
}


@Composable
fun FirstRow(movie: Movie) {
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
                .border(1.5.dp, MaterialTheme.colorScheme.primary)
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
fun MovieDetails(movie: Movie) {
    Column {
        FirstRow(movie = movie)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Scenes",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                )
                ScenesGrid(photos = movie.scenes)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Starring",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                )
                ActorList(actors = movie.actors)
            }
        }
    }
}

@Composable
fun ActorCard(actor: Actor) {
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
                .size(60.dp)
                .border(1.5.dp, MaterialTheme.colorScheme.primary)
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
fun ActorList(actors: List<Actor>) {
    LazyColumn {
        items(actors) { actor ->
            ActorCard(actor = actor)
        }
    }
}



@Preview
@Composable
fun PreviewFirstRow() {
    FavFilmsAppTheme {
        MovieDetails(movie = SampleData.movies[0])
    }
}
