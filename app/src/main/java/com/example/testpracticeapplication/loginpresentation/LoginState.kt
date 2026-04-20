package com.example.testpracticeapplication.loginpresentation

data class LoginState (val email: String= "", val password : String ="", val error: String="", val isSubmitted: Boolean= false) {
}