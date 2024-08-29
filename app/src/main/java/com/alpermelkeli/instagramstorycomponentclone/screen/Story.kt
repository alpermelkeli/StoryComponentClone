package com.alpermelkeli.instagramstorycomponentclone.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alpermelkeli.instagramstorycomponentclone.components.ShimmerEffectImage
import com.alpermelkeli.instagramstorycomponentclone.components.StoryTopBar
import com.alpermelkeli.instagramstorycomponentclone.repository.storiesList
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Story(onBackClicked:()->Unit){
    val scope = rememberCoroutineScope()

    val stories = storiesList

    var currentPage by remember{ mutableIntStateOf(0) }

    val pagerState = rememberPagerState(initialPage = 0) {
        stories.size
    }

    var targetStoriesList by remember {
        mutableStateOf(stories[pagerState.currentPage].second)
    }

    LaunchedEffect(pagerState.currentPage) {
        currentPage = 0
        targetStoriesList = stories[pagerState.currentPage].second
    }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = true
    ) {


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Black,
            topBar = {
                StoryTopBar(
                    currentStoryIndex = currentPage,
                    totalStories = targetStoriesList.size,
                    username = targetStoriesList[0].username,
                    onBackClicked = {onBackClicked()},
                    profilePhoto = targetStoriesList[0].profilePhoto,
                    onTimeFinished = {
                        if (currentPage < targetStoriesList.size - 1) {
                            currentPage++
                        }
                        else {
                            if (pagerState.currentPage  < stories.size-1) {
                                scope.launch { pagerState.animateScrollToPage(pagerState.targetPage + 1) }
                            }
                            else {
                                onBackClicked()
                            }
                        }
                    }
                )
            }
        ){

            ShimmerEffectImage(
                modifier = Modifier
                    .fillMaxHeight(0.85f)
                    .fillMaxWidth()
                    .clip(ShapeDefaults.Large)
                    .padding(top = 30.dp),
                data = targetStoriesList[currentPage].image
            )

            // Handle tapping on the left or right side to go to the previous or next story
            Row(Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.5f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            if (currentPage > 0) {
                                currentPage--
                            }
                        }
                        .background(Color.Transparent)
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.5f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            if (currentPage < targetStoriesList.size - 1) {
                                currentPage++
                            }
                        }
                        .background(Color.Transparent)
                )
            }
        }
    }


}