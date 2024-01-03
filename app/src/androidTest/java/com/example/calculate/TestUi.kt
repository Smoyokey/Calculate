package com.example.calculate

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.calculate.model.Action
import com.example.calculate.model.CalculateUiState
import com.example.calculate.ui.CalculateApp
import com.example.calculate.ui.toRes
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Деление на 0
 * Кнопка очистить
 */

class TestUi {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val numberOne = "20"
    private val numberTwo = "5"

    @Before
    fun createScreen() {
        composeTestRule.setContent {
            CalculateApp()
        }
    }

    @Test
    fun testAction_oneSumOne_result() {
        val action = "+"
        startTest(action, "25")
    }

    @Test
    fun testAction_oneSubtractionOne_result() {
        val action = "-"
        startTest(action, "15")
    }

    @Test
    fun testAction_oneMultiplicationOne_result() {
        val action = "*"
        startTest(action, "100")
    }

    @Test
    fun testAction_oneDivisionOne_result() {
        val action = "/"
        startTest(action, "4")
    }

    @Test
    fun testAction_buttonReset_click() {
        val action = "*"
        startTest(action, "100")

        composeTestRule.onNodeWithStringId(R.string.reset).performClick()

        composeTestRule.onNodeWithText(" + =").assertIsDisplayed()
    }

    @Test
    fun testAction_divisionByZero_result() {
        composeTestRule.onNodeWithStringId(R.string.writeNumberOne).performTextInput("10")
        composeTestRule.onNodeWithStringId(R.string.writeNumberTwo).performTextInput("0")
        composeTestRule.onNodeWithText("/").performClick()

        composeTestRule
            .onNodeWithText("10 / 0 = Denied").assertIsDisplayed()
    }

    private fun startTest(action: String, res: String) {
        composeTestRule.onNodeWithStringId(R.string.writeNumberOne).performTextInput(numberOne)
        composeTestRule.onNodeWithStringId(R.string.writeNumberTwo).performTextInput(numberTwo)
        composeTestRule.onNodeWithText(action).performClick()

        composeTestRule
            .onNodeWithText("$numberOne $action $numberTwo = $res")
            .assertIsDisplayed()
    }
}