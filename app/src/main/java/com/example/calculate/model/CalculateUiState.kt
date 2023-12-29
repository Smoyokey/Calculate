package com.example.calculate.model

data class CalculateUiState(
    val numberOne: String = "",
    val numberTwo: String = "",
    val action: Action = Action.SUM,
)