package com.footballmanager.game.data

data class Manager(
    val name: String,
    val age: Int,
    val style: ManagerStyle
)

enum class ManagerStyle {
    BALANCED,
    ATTACKING,
    DEFENSIVE
}