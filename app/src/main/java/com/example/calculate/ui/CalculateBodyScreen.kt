package com.example.calculate.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.example.calculate.model.CalculateUiState

@Composable
fun CalculateBodyScreen(
    modifier: Modifier = Modifier,
    uiState: CalculateUiState,
    onValueChangeNumberOne: (String) -> Unit,
    onValueChangeNumberTwo: (String) -> Unit,
) {

    var action by remember { mutableStateOf("") }
    var result: String? = ""

    Column {
        Text(text = stringResource(id = R.string.numberOne))

        TextField(
            value = uiState.numberOne,
            onValueChange = onValueChangeNumberOne
        )

        Text(text = stringResource(id = R.string.action))



        Text(text = stringResource(id = R.string.numberTwo))

        TextField(
            value = uiState.numberTwo,
            onValueChange = onValueChangeNumberTwo
        )

        Text(text = stringResource(id = R.string.result))

        TextField(
            value = uiState.result,
            onValueChange = {}
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun CalculateBodyScreenPreview() {
//    CalculateBodyScreen()
//}
