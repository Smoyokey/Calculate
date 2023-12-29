package com.example.calculate.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.*
import com.example.calculate.model.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculateApp(
    viewModel: CalculateViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {}
    ) { _ ->
        CalculateBodyScreen(
//            uiState = uiState,
//            onValueChangeNumberOne = { numberOne ->
//                viewModel.enterNumberOne(numberOne)
//            },
//            onValueChangeNumberTwo = {numberTwo ->
//                viewModel.enterNumberTwo(numberTwo)
//            },
            viewModel = viewModel
        )
    }
}