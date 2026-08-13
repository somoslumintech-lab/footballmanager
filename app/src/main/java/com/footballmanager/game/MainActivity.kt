package com.footballmanager.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import com.footballmanager.game.ui.screens.HomeScreen
import com.footballmanager.game.ui.screens.NewCareerScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {

                    var currentScreen by remember {
                        mutableStateOf("home")
                    }

                    when (currentScreen) {

                        "home" -> {
                            HomeScreen(
                                onNewCareerClick = {
                                    currentScreen = "new_career"
                                },
                                onLoadGameClick = {
                                    // Sistema de carregamento será implementado depois.
                                }
                            )
                        }

                        "new_career" -> {
                            NewCareerScreen(
                                onContinueClick = {
                                    // Próxima etapa: escolha do clube.
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}