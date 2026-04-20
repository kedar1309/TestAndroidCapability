package com.example.testpracticeapplication.counterpresentation

sealed interface UserIntent {

    object AddClicked : UserIntent
    object  MinusClicked : UserIntent
}