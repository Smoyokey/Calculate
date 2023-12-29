package com.example.calculate.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculate.model.Action
import com.example.calculate.model.CalculateUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculateViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculateUiState())
    val uiState: StateFlow<CalculateUiState> = _uiState.asStateFlow()

    fun enterNumberOne(number: String) {
        _uiState.update { updateOne ->
            updateOne.copy(
                numberOne = number
            )
        }
        result()
    }

    fun enterNumberTwo(number: String) {
        _uiState.update { updateTwo ->
            updateTwo.copy(
                numberTwo = number
            )
        }
        result()
    }

    fun clickAction(actions: Action) {
        _uiState.update { action ->
            action.copy(
                action = actions
            )
        }
        result()
    }

    fun reset() {
        _uiState.value = CalculateUiState()
    }

    private fun result() {
        _uiState.update {result ->
            if(uiState.value.numberOne != "" && uiState.value.numberTwo != "") {
                result.copy(
                    result = "${uiState.value.numberOne} ${uiState.value.action.sign} ${uiState.value.numberTwo} = " +
                            mathAction(uiState.value.action.sign, uiState.value.numberOne, uiState.value.numberTwo)
                )
            } else {
                result.copy(
                    result = "${uiState.value.numberOne} ${uiState.value.action.sign} ${uiState.value.numberTwo} = "
                )
            }
        }
    }

    private fun mathAction(sign: String, numberOne: String, numberTwo: String): String {
        val numOne = numberOne.toInt()
        val numTwo = numberTwo.toInt()
        val res = if(sign == Action.SUM.sign) {
            (numOne + numTwo).toString()
        } else if(sign == Action.SUBTRACTION.sign) {
            (numOne - numTwo).toString()
        } else if(sign == Action.MULTIPLICATION.sign) {
            (numOne * numTwo).toString()
        } else {
            if(numTwo == 0) {
                "Denied"
            } else {
                (numOne / numTwo).toString()
            }
        }
        return res
    }

}