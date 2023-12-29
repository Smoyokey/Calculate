package com.example.calculate.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculate.R
import com.example.calculate.data.DataSource
import com.example.calculate.model.Action
import com.example.calculate.model.CalculateUiState

@Composable
fun CalculateBodyScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculateViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    var action by remember { mutableStateOf("") }

    Column {
        Text(text = stringResource(id = R.string.numberOne))

        TextField(
            value = uiState.numberOne,
            onValueChange = {
                viewModel.enterNumberOne(it)
            }
        )

        Text(text = stringResource(id = R.string.action))

        Row() {
            DataSource.actions.forEach {
                Button(
                    onClick = {
                        viewModel.clickAction(it)
                    }
                ) {
                    Text(text = it.sign)
                }
            }
        }

        Text(text = stringResource(id = R.string.numberTwo))

        TextField(
            value = uiState.numberTwo,
            onValueChange = {
                viewModel.enterNumberTwo(it)
            }
        )

        Text(text = stringResource(id = R.string.result))

        TextField(
            value = uiState.result,
            onValueChange = {}
        )
    }
}

