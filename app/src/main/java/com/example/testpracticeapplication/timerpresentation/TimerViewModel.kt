package com.example.testpracticeapplication.timerpresentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TimerViewModel: ViewModel() {

    private val _timervalue = MutableStateFlow(0)
    val timervalue = _timervalue

    var job : Job? = null

    fun startTimerFrom (time : Int){
        job?.cancel()
        job=  viewModelScope.launch {
            for (i in time downTo 0){
                _timervalue.value = i
                delay(1000)
            }
        }
    }

    fun pauseTimer(){
        job?.cancel()
    }

    fun resetTimer(){
        job?.cancel()
        _timervalue.value = 0
    }

}