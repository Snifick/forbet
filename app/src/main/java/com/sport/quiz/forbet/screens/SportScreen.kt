package com.sport.quiz.forbet.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sport.quiz.forbet.LevelPanel
import com.sport.quiz.forbet.R
import com.sport.quiz.forbet.SportPanel
import com.sport.quiz.forbet.TopBar
import com.sport.quiz.forbet.model.LevelModel
import com.sport.quiz.forbet.model.SportType
import com.sport.quiz.forbet.ui.theme.background
import com.sport.quiz.forbet.ui.theme.green
import com.sport.quiz.forbet.ui.theme.secondary
import kotlinx.coroutines.delay

@Composable
fun SportScreen(sportType: SportType,levelSelected:(level: LevelModel)->Unit){

    val showMenu = remember { mutableStateOf(false) }
    val needShowIndicator = remember { mutableStateOf(true) }
    val indicatorProgress = remember { Animatable(0f) }

    val needShowAllInfo = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        indicatorProgress.animateTo(1f, tween(200))
        delay(200)
        needShowIndicator.value = false
    }
    LaunchedEffect(needShowIndicator.value) {
        if (!needShowIndicator.value) {
            delay(300)
            needShowAllInfo.value = true
        }
    }

    Box(
        Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(background)

        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(background)
            )

            TopBar(iconId = R.drawable.round_dehaze_24, iconOnClick = {
                showMenu.value = true

            }, title = sportType.type.toString(), {}, showMenu = showMenu)

            AnimatedVisibility(visible = needShowIndicator.value, enter = fadeIn(), exit = fadeOut()) {
                LinearProgressIndicator(
                    progress = indicatorProgress.value,
                    color = green,
                    trackColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                )
            }
                    AnimatedVisibility(visible = !needShowIndicator.value, enter = fadeIn() + slideInVertically { (it*0.7f).toInt() }, exit = fadeOut()) {
                        Column(modifier = Modifier
                            .background(background)
                            .fillMaxSize()
                            .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            LevelPanel(sportType = sportType , completedQuiz = 10, goPlay = levelSelected , levelNumber = 1 )
                            LevelPanel(sportType = sportType , completedQuiz = 10, goPlay = levelSelected , levelNumber = 2 )
                            LevelPanel(sportType = sportType , completedQuiz = 7, goPlay = levelSelected , levelNumber = 3 )
                            LevelPanel(sportType = sportType , completedQuiz = 0, goPlay = levelSelected , levelNumber = 4 )
                            LevelPanel(sportType = sportType , completedQuiz = 0, goPlay = levelSelected , levelNumber = 5 )
                        }
                    }



                }
            }

        }


