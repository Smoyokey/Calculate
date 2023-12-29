package com.example.calculate.model

data class CalculateUiState(
    val numberOne: String = "",
    val numberTwo: String = "",
    val action: Action = Action.SUM,
    val result: String = numberOne + Action.SUM.sign + numberTwo
)