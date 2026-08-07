package com.footballmanager.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.footballmanager.game.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {
                    HomeScreen(
                        onNewCareerClick = {
                            // Vamos implementar a nova carreira depois.
                        },
                        onLoadGameClick = {
                            // Vamos implementar o carregamento depois.
                        }
                    )
                }
            }
        }
    }
}