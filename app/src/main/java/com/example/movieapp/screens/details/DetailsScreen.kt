package com.example.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.screens.home.MainContent
import com.example.movieapp.widgets.HorizontalMovieList
import com.example.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {

    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(
          topBar = {
              CenterAlignedTopAppBar(
                  colors = TopAppBarDefaults.smallTopAppBarColors(
                      containerColor = MaterialTheme.colorScheme.primaryContainer,
                      titleContentColor = MaterialTheme.colorScheme.primary
                  ),
                  title = { Text(text = "Movies", maxLines = 1, overflow = TextOverflow.Ellipsis) },

                  navigationIcon = {
                      IconButton(onClick = {navController.popBackStack()}) {
                          Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="Arrow Back" )
                      }
                  },
                  actions = {
                      IconButton(onClick = { /* do something */ }) {
                          Icon(
                              imageVector = Icons.Filled.Menu,
                              contentDescription = "Localized description"
                          )
                      }
                  }
              )
          }

        ) {
            innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {


            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(movie = newMovieList.first(),)
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalMovieList(newMovieList)

            }
        }
    }


}
