package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies



@Preview
@Composable

fun MovieRow(movie: Movie = getMovies()[0],
             onItemClick: (String) -> Unit ={}) {

    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier= Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie.id) },
//            .height(130.dp),
        shape= RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)

    ){
        Row(
            verticalAlignment= Alignment.CenterVertically,
            horizontalArrangement= Arrangement.Start
        ){
            Surface (
                color=Color.Transparent,
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
//                shadowElevation =4.dp
            ){
//                Icon(imageVector = reme,
//                    contentDescription ="Movie Image" )

               AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                   .data(movie.images[0])
                   .crossfade(true)
                   .build(),
                   modifier= Modifier
                       .clip(CircleShape)
                       .fillMaxHeight(),
                   contentScale = ContentScale.FillBounds,
                   contentDescription = "Movie Image")
            }

            Column (
                modifier=Modifier.padding(4.dp)
            ){

                Text(text = movie.title,)
                Text(text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.labelMedium)
                Text(text = "Released: ${movie.year}",)

                AnimatedVisibility(visible = expanded) {
                    Column {
                       Text(text = buildAnnotatedString {
                           withStyle(style = SpanStyle(color = Color.DarkGray,
                               fontSize = 13.sp)){
                               append("Plot:")
                           }

                           withStyle(style = SpanStyle(color = Color.DarkGray,
                               fontSize = 13.sp, fontWeight = FontWeight.Light)){
                               append(movie.plot)
                           }
                       },modifier=Modifier.padding(6.dp))

                        Divider(modifier=Modifier.padding(6.dp))
                        Text(text = "Director: ${movie.director}",)
                        Text(text = "Actors: ${movie.actors}",)
                        Text(text = "Rating: ${movie.rating}",)
                    }
                }


                Icon(imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded = !expanded },
                    tint = Color.DarkGray,
                    contentDescription = "Down Arrow")
            }

        }

    }
}



@Composable
fun HorizontalMovieList(newMovieList: List<Movie>) {
    LazyRow() {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Movie Image"
                )
            }
        }
    }
}
