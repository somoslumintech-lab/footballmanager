package com.footballmanager.game.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.footballmanager.game.data.Manager
import com.footballmanager.game.data.ManagerStyle

@Composable
fun ManagerCreationScreen(
    onContinueClick: (Manager) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }

    var ageText by remember {
        mutableStateOf("35")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedStyle by remember {
        mutableStateOf(ManagerStyle.BALANCED)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "👔 CRIAR TREINADOR",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Nome")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = ageText,
            onValueChange = {
                ageText = it.filter { character ->
                    character.isDigit()
                }
            },
            label = {
                Text("Idade")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {

            OutlinedTextField(
                value = when (selectedStyle) {
                    ManagerStyle.BALANCED -> "Equilibrado"
                    ManagerStyle.ATTACKING -> "Ofensivo"
                    ManagerStyle.DEFENSIVE -> "Defensivo"
                },
                onValueChange = {},
                readOnly = true,
                label = {
                    Text("Estilo")
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {

                DropdownMenuItem(
                    text = {
                        Text("Equilibrado")
                    },
                    onClick = {
                        selectedStyle = ManagerStyle.BALANCED
                        expanded = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Ofensivo")
                    },
                    onClick = {
                        selectedStyle = ManagerStyle.ATTACKING
                        expanded = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Defensivo")
                    },
                    onClick = {
                        selectedStyle = ManagerStyle.DEFENSIVE
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val age = ageText.toIntOrNull() ?: 35

                val manager = Manager(
                    name = name.ifBlank {
                        "Novo Treinador"
                    },
                    age = age,
                    style = selectedStyle
                )

                onContinueClick(manager)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONTINUAR")
        }
    }
}