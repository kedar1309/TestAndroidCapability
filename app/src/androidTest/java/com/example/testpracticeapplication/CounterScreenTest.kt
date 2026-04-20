package com.example.testpracticeapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testcounterincrement() {
        composeTestRule.setContent {
            CounterComputation()
        }

        composeTestRule
            .onNodeWithTag("Add")
            .performClick()

        composeTestRule
            .onNodeWithText("Counter value = 1")
            .assertIsDisplayed()

    }
}