package com.example.favfilmsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
            fontSize = 16.sp
        )
    }
}

//@Preview(name = "Light Mode")
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)

//@Composable
//fun PreviewMovieCard() {
//    FavFilmsAppTheme {
//        Surface {
//            MovieCard(
//                movie = Movie(title="that is my title", imageResource = R.drawable.title, description = "", actors = listOf() , scenes = listOf()),
//            )
//        }
//    }
//}


@Composable
fun MainScreen(movies: List<Movie>, onMovieClick: (Movie) -> Unit) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie = movie, onMovieClick)
        }
    }
}

@Composable
fun MovieDetails(movie: Movie) {

}


//@Preview
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
//@Composable
//fun PreviewConversation() {
//    FavFilmsAppTheme {
//        MainScreen(SampleData.movies, ())
//    }
//}

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