package com.example.calculate.model

enum class Action(val sign: String) {
    SUM(sign = "+"),
    SUBTRACTION(sign = "-"),
    MULTIPLICATION(sign = "*"),
    DIVISION(sign = "/")
}