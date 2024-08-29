package com.alpermelkeli.instagramstorycomponentclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alpermelkeli.instagramstorycomponentclone.screen.Main
import com.alpermelkeli.instagramstorycomponentclone.screen.Story

@Composable
fun MainNavController(startDestination : String){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable(NavRoutes.MainScreen.route){
            Main(onStoryClicked = {navController.navigate(NavRoutes.StoryScreen.route)})
        }

        composable(NavRoutes.StoryScreen.route){
            Story(onBackClicked = {navController.popBackStack()})
        }

    }
}