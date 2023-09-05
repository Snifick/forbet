package com.sport.quiz.forbet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import com.sport.quiz.forbet.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sport.quiz.forbet.ui.theme.blue

@Composable
fun WelcomeScreen( editSharPrefAndGoForward:()->Unit){

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "", contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize())
        Image(painter = painterResource(id = R.drawable.welcome_text),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 128.dp)
                .align(Alignment.TopCenter)
                .scale(1.3f),)

        Text(text = "Try your sport knowledge in a funny quiz! Matches, Players, Events etc.",
            fontSize = 16.sp, color = Color.White, textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 120.dp),
            fontWeight = FontWeight.ExtraBold)

        Button(onClick = { editSharPrefAndGoForward.invoke() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp).padding(bottom = 54.dp).fillMaxWidth().height(64.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = blue,
                contentColor = Color.White)) {
                    Text("Next", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        }
    }


}