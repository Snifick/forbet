package com.sport.quiz.forbet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sport.quiz.forbet.model.LevelModel
import com.sport.quiz.forbet.model.SportType
import com.sport.quiz.forbet.ui.theme.background
import com.sport.quiz.forbet.ui.theme.blue
import com.sport.quiz.forbet.ui.theme.green
import com.sport.quiz.forbet.ui.theme.primary
import com.sport.quiz.forbet.ui.theme.secondary

const val quiz1 = "quiz1"
const val quiz2 = "quiz2"
const val quiz3 = "quiz3"
const val quiz4 = "quiz4"
const val quiz5 = "quiz5"
const val quiz6 = "quiz6"
const val quiz7 = "quiz7"
const val quiz8 = "quiz8"
const val quiz9 = "quiz9"
const val quiz10 = "quiz10"



@Composable
fun QuizTemplate(levelModel: LevelModel,
                 question:String,
                 answers:List<String>,
                 rightAnswerNumber:Int,
                 answersState:MutableState<Int>,
                 showMenu:MutableState<Boolean>,
                 goNext:()->Unit,
                 goLevelMenu:()->Unit
                 ) {
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

            }, title = levelModel.sportType.type, {}, showMenu = showMenu)
            Text(text = question)
            answers.forEach { 
                Text(text = it)
            }
            Text(text = rightAnswerNumber.toString())
            Button(onClick = { goNext.invoke() }) {
                Text(text = "Next")
            }
        }
    }
}





@Composable
fun TopBar(iconId:Int, iconOnClick:()->Unit, title:String, actions:@Composable RowScope.()->Unit, onePhotoMode:Boolean = false, showMenu: MutableState<Boolean>? = null){

    val onePhotoModePadding = Modifier.padding(start = 48.dp)
    val simplePadding =  Modifier.padding(start = 16.dp)
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(primary),
        contentAlignment = Alignment.Center) {
        IconButton(onClick = { iconOnClick.invoke() },modifier = Modifier
            .then(simplePadding)
            .align(Alignment.CenterStart)
            .size(24.dp)) {
            Icon(painter = painterResource(id = iconId), contentDescription =null,
                modifier = Modifier.size(24.dp), tint = Color(0xFF5A92DD)
            )
            if (showMenu != null) {
                DropdownMenu(expanded =showMenu.value, onDismissRequest = { showMenu.value = false},modifier = Modifier.background(
                    Color(0xFFE7E7E7)
                )) {
                    DropdownMenuItem(
                        text = {  Text("Privacy Policy", color = Color.Black) },
                        onClick = { /* Handle refresh! */ },
                        colors = MenuDefaults.itemColors()
                    )
                }
            }
        }
        Text(text = title, fontSize = 18.sp,color = secondary, modifier = Modifier
            .align(if (!onePhotoMode) Alignment.Center else Alignment.CenterStart)
            .then(if (onePhotoMode) onePhotoModePadding else Modifier))
        Row(modifier = Modifier.align(Alignment.CenterEnd), horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            actions.invoke(this)
        }
    }
}

@Composable
fun SportPanel(sportType: SportType,completedLevels:Int,goPlay: (sportType: SportType) -> Unit){
    Column(modifier = Modifier
        .clip(RoundedCornerShape(10))
        .background(secondary)
        .padding(horizontal = 16.dp, vertical = 12.dp)){
        Box(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.align(Alignment.CenterStart), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${sportType.type}", fontSize = 18.sp,color = Color.White)
                    Text(text = "  ${completedLevels}/5", fontSize = 14.sp,color = Color.Gray)
                }
            IconButton(onClick = { goPlay.invoke(sportType) },modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(painter = painterResource(id = R.drawable.round_arrow_forward_24),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Center),
                    tint = Color.White)
            }
        }
        LinearProgressIndicator(progress = completedLevels.toFloat()/5,color = green, trackColor = Color.White, modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth())

    }

}

@Composable
fun LevelPanel(sportType: SportType,completedQuiz:Int,goPlay: (levelModel: LevelModel) -> Unit,levelNumber:Int){
    Column(modifier = Modifier
        .clip(RoundedCornerShape(10))
        .background(secondary)
        .padding(horizontal = 16.dp, vertical = 12.dp)){
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.align(Alignment.CenterStart), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Level $levelNumber", fontSize = 18.sp,color = Color.White)
                Text(text = "  ${completedQuiz}/10", fontSize = 14.sp,color = Color.Gray)
            }
            IconButton(onClick = { goPlay.invoke(LevelModel(sportType,levelNumber,false)) },modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(painter = painterResource(id = R.drawable.round_arrow_forward_24),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Center),
                    tint = Color.White)
            }
        }
        LinearProgressIndicator(progress = completedQuiz.toFloat()/10,color = green, trackColor = Color.White, modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth())

    }

}