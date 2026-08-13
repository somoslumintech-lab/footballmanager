package com.footballmanager.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.footballmanager.game.data.BrazilianClubs
import com.footballmanager.game.data.Club
import com.footballmanager.game.ui.screens.ClubConfirmationScreen
import com.footballmanager.game.ui.screens.ClubSelectionScreen
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

                    var selectedClub by remember {
                        mutableStateOf<Club?>(null)
                    }

                    when (currentScreen) {

                        "home" -> {
                            HomeScreen(
                                onNewCareerClick = {
                                    currentScreen = "new_career"
                                },
                                onLoadGameClick = {
                                    // Implementaremos depois.
                                }
                            )
                        }

                        "new_career" -> {
                            NewCareerScreen(
                                onContinueClick = {
                                    currentScreen = "club_selection"
                                }
                            )
                        }

                        "club_selection" -> {
                            ClubSelectionScreen(
                                clubs = BrazilianClubs.clubs,
                                onClubSelected = { club ->
                                    selectedClub = club
                                    currentScreen = "club_confirmation"
                                }
                            )
                        }

                        "club_confirmation" -> {

                            selectedClub?.let { club ->

                                ClubConfirmationScreen(
                                    club = club,

                                    onConfirmClick = {
                                        // Próxima etapa:
                                        // criação do treinador.
                                    },

                                    onBackClick = {
                                        currentScreen = "club_selection"
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}