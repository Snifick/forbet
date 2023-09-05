package com.sport.quiz.forbet

import android.content.Context
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sport.quiz.forbet.model.LevelModel
import com.sport.quiz.forbet.model.SportType
import com.sport.quiz.forbet.screens.HomeScreen
import com.sport.quiz.forbet.screens.QuizScreen
import com.sport.quiz.forbet.screens.SplashScreen
import com.sport.quiz.forbet.screens.SportScreen
import com.sport.quiz.forbet.screens.WelcomeScreen
import com.sport.quiz.forbet.ui.theme.ForBetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = getSharedPreferences("forbet", Context.MODE_PRIVATE)
       WindowCompat.setDecorFitsSystemWindows(window,false)
        val wcontroller = WindowCompat.getInsetsController(window,window.decorView)
        wcontroller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        wcontroller.hide(WindowInsetsCompat.Type.navigationBars())
        setContent {
            ForBetTheme {
                val levelsDone = remember {
                    mutableStateOf(sharedPreferences.getInt("levelsDone",0))
                }
                val quizsDone = remember {
                    mutableStateOf(sharedPreferences.getInt("quiz",0))
                }
                val selectedSportType = remember{
                    mutableStateOf<SportType>(SportType.Football)
                }
                val selectedLevelModel = remember{
                    mutableStateOf<LevelModel?>(null)
                }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.splashScreen ){
                    composable(Screens.splashScreen){
                        SplashScreen(goForward = {
                            if(sharedPreferences.getBoolean("needOpenWelcome",true))
                                navController.navigate(Screens.welcomeScreen){launchSingleTop=true}
                            else
                                navController.navigate(Screens.homeScreen){launchSingleTop=true}
                        })
                    }

                    composable(Screens.welcomeScreen){
                            WelcomeScreen(editSharPrefAndGoForward = {
                                sharedPreferences.edit().putBoolean("needOpenWelcome",false).apply()
                                navController.navigate(Screens.homeScreen){launchSingleTop=true}
                            })
                    }

                    composable(Screens.homeScreen){
                            HomeScreen(openSport = {
                                sportType ->  
                                selectedSportType.value = sportType
                                navController.navigate(Screens.sportScreen){launchSingleTop=true}

                            } ,levelsDone,
                                quizsDone,
                                goPlay = {
                                    selectedSportType.value = it
                                    navController.navigate(Screens.sportScreen){launchSingleTop=true}
                                })
                        
                    }

                    composable(Screens.sportScreen){
                            SportScreen(
                                sportType = selectedSportType.value,
                                levelSelected = { level ->
                                selectedLevelModel.value = level
                                    navController.navigate(Screens.quizScreen){launchSingleTop = true}
                                }
                                )
                    }
                    composable(Screens.quizScreen){
                       AnimatedVisibility(selectedLevelModel.value!=null){
                            QuizScreen(levelModel = selectedLevelModel.value!!, navController = navController)
                        }

                    }



                }

            }
        }
    }
}

