package com.example.calculate.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculateApp(
    viewModel: CalculateViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {}
    ) { _ ->
        CalculateBodyScreen(
            viewModel = viewModel
        )
    }
}