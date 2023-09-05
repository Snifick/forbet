package com.sport.quiz.forbet.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import  com.sport.quiz.forbet.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sport.quiz.forbet.ui.theme.green
import com.sport.quiz.forbet.ui.theme.primary

@Composable
fun SplashScreen(goForward:()->Unit){
    val progress = remember{ Animatable(0f) }
    LaunchedEffect(Unit){
        progress.animateTo(1f, tween(1000))
        goForward.invoke()
    }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECEEF5)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(id = R.drawable.for_img),
                contentDescription = "")
            LinearProgressIndicator(modifier = Modifier.padding(32.dp).size(313.dp,4.dp),
                color = green, trackColor = Color.White,
                progress = progress.value
                )

        }
}