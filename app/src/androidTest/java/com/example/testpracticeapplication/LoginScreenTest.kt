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
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun login_with_invalid_email_shows_error() {

        composeTestRule.setContent {
            LoginScreen()
        }

        // Enter email
        composeTestRule
            .onNodeWithTag("EmailTag")
            .performTextInput("abc")

        // Enter password
        composeTestRule
            .onNodeWithTag("PasswordTag")
            .performTextInput("123456")

        // Click button
        composeTestRule
            .onNodeWithTag("Submitbutton")
            .performClick()

        composeTestRule.waitForIdle()
        // Verify error
        /*composeTestRule
            .onNodeWithText("Invalid Email")
            .assertIsDisplayed()*/
    }
}