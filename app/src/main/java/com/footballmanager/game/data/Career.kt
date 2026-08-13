package com.footballmanager.game.data

data class Career(
    val managerName: String,
    val club: Club,
    val season: Int = 2026,
    val money: Long = 10_000_000L
)