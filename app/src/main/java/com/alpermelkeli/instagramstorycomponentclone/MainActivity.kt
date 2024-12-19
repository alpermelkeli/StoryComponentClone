package com.alpermelkeli.instagramstorycomponentclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alpermelkeli.instagramstorycomponentclone.repository.Story
import com.alpermelkeli.instagramstorycomponentclone.screen.Stories

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Stories(onReturnBack = {}, stories = listOf(Pair("Alper", listOf(Story("profile", "alpermelkeli","imageurl")))))
        }
    }
}

