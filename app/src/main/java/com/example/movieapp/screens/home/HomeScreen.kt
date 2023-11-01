package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies") },
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(MaterialTheme.colorScheme.primary),
            )
        },

        ) {
            innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            MainContent(navController=navController)
        }

    }
}


@Composable
fun MainContent(navController: NavController,movieList:List<String> =
                    listOf(
                        "Last of Us 2",
                        "Lord of The Rings",
                        "Happy Feet 1",
                        "300",
                        "The Nun",
                        "The hobbit",
                        "Transformers",
                        "Gladiator",
                        "Coco",
                        "World War Z",
                        "Civil War",
                    )) {

    Column (
        modifier=Modifier.padding(12.dp)
    ){
        LazyColumn {
            items(items =  movieList){
                MovieRow(movie = it){movie->
                    navController
                        .navigate(route = MovieScreens.DetailScreen.name+"/$movie")
                }

            }
        }
    }

}
//16