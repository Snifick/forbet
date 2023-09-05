package com.sport.quiz.forbet.screens

import android.content.res.Resources
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sport.quiz.forbet.model.LevelModel
import com.sport.quiz.forbet.*

@Composable
fun QuizScreen(levelModel: LevelModel,navController: NavController){
    val quizNavController = rememberNavController()
    val context = LocalContext.current
    val answerState=  remember {
        mutableStateOf(0)
    }
    val showMenu = remember { mutableStateOf(false) }
    NavHost(navController = quizNavController, startDestination = quiz1){
        composable(quiz1){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_1_question","string",context.packageName)),
                answers = listOf(
                            stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_1_1","string",context.packageName)),
                            stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_1_2","string",context.packageName)),
                            stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_1_3","string",context.packageName)),
                            stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_1_4","string",context.packageName))

                ),
                rightAnswerNumber = 
                            stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_1_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz2){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz2){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_2_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_2_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_2_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_2_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_2_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_2_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz3){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }

        composable(quiz3){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_3_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_3_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_3_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_3_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_3_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_3_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz2){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz4){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_4_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_4_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_4_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_4_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_4_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_4_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz5){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz5){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_5_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_5_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_5_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_5_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_5_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_5_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz6){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz6){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_6_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_6_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_6_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_6_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_6_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_6_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz7){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz7){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_7_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_7_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_7_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_7_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_7_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_7_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz8){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz8){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_8_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_8_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_8_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_8_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_8_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_8_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz9){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz9){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_9_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_9_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_9_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_9_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_9_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_9_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz2){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        composable(quiz10){
            QuizTemplate(
                levelModel = levelModel,
                question =  stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_10_question","string",context.packageName)),
                answers = listOf(
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_10_1","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_10_2","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_10_3","string",context.packageName)),
                    stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_10_4","string",context.packageName))

                ),
                rightAnswerNumber =
                stringResource(id =context.resources.getIdentifier("${levelModel.sportType.type}_${levelModel.level}_10_answer","string",context.packageName)).toInt() ,
                answersState = answerState,
                goNext = {quizNavController.navigate(quiz10){launchSingleTop=true} },
                goLevelMenu = {navController.popBackStack()},
                showMenu = showMenu
            )
        }
        
    }


}