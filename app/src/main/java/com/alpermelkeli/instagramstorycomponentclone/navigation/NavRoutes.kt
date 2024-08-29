package com.alpermelkeli.instagramstorycomponentclone.navigation

sealed class NavRoutes(val route:String) {
    object MainScreen : NavRoutes("mainScreen")
    object StoryScreen : NavRoutes("storyScreen")
}