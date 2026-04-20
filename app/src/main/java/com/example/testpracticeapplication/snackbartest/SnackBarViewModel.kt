package com.example.testpracticeapplication.snackbartest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SnackBarViewModel: ViewModel() {

    private val _state = MutableSharedFlow<String>()
    val state = _state.asSharedFlow()

    fun onButtonClick(){
        viewModelScope.launch {
            _state.emit("Hello snackbar")
        }
    }


}