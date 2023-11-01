package com.example.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {

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
        Surface (
            modifier= Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){

        }
        Column (
            modifier=Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Text(text = movieData.toString(), style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(23.dp))

        }
    }


}