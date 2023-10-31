package com.example.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content:@Composable () -> Unit) {
    MovieAppTheme {
       Scaffold(
           topBar = {
               TopAppBar(
                   title = { Text(text = "Movies") },
                   colors = TopAppBarDefaults
                       .smallTopAppBarColors(Color.Magenta),
                   )
           },

       ) {
               innerPadding ->
           Box(modifier = Modifier.padding(innerPadding)){
               content()
           }

       }
        
    }
}

@Composable
fun MainContent(movieList:List<String> =
                    listOf("Life After",
                        "Love Alone",
                        "Hate Job 4",
                        "Lust And Religion",
                        "Joy Riders 2",
                        "Like It Was")) {

        Column (
            modifier=Modifier.padding(12.dp)
        ){
        LazyColumn {
            items(items =  movieList){
                MovieRow(movie = it){movie->
                    Log.d("Movie", "MainContent: $movie")
                }


            }
        }
        }

}
//16..006

@Composable
fun MovieRow(movie:String,onItemClick: (String) -> Unit) {
    Card(
        modifier= Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .height(130.dp),
        shape= RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)

    ){
        Row(
            verticalAlignment= Alignment.CenterVertically,
            horizontalArrangement=Arrangement.Start
        ){
            Surface (
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shadowElevation =4.dp
            ){
                Icon(imageVector = Icons.Default.AccountBox,
                    contentDescription ="Movie Image" )
            }
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   MyApp {
       MainContent()
   }
}