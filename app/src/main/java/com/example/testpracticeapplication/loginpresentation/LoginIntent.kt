package com.example.testpracticeapplication.loginpresentation

sealed class LoginIntent {

    data class EmailChanged(val email: String) : LoginIntent()
    data class PasswordChanges(val pass : String): LoginIntent()
    object onLoginClicked: LoginIntent()
}