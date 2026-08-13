package com.footballmanager.game.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.footballmanager.game.data.Club

@Composable
fun ClubSelectionScreen(
    clubs: List<Club>,
    onClubSelected: (Club) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "ESCOLHA SEU CLUBE",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Brasil",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(clubs) { club ->

                Button(
                    onClick = {
                        onClubSelected(club)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column {

                        Text(
                            text = club.name,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "${club.city} • Força ${club.strength}"
                        )
                    }
                }
            }
        }
    }
}