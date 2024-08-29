package com.alpermelkeli.instagramstorycomponentclone.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Main(onStoryClicked:()->Unit){

    Box(Modifier.fillMaxSize()) {
        Button(onClick = {onStoryClicked()}) {
            Text(text = "Go to stories.")
        }
    }
}