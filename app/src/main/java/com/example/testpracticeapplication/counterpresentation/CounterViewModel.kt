package com.example.testpracticeapplication.counterpresentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterViewModel: ViewModel() {


    private val _countval = MutableStateFlow(CounterValue())
    val countval = _countval

    private val _showmessage = MutableSharedFlow<CounterEffects>()
    val showmessage = _showmessage

    fun processIntent(userIntent: UserIntent){
        when (userIntent){
            UserIntent.AddClicked -> AddButtonClicked()
            UserIntent.MinusClicked -> MinusButtonClicked()
        }
    }

    fun AddButtonClicked(){
        _countval.update {   _countval.value.copy(countvalue = _countval.value.countvalue + 1)}
    }

    fun MinusButtonClicked(){
        if(_countval.value.countvalue > 0){
            _countval.update { _countval.value.copy(countvalue = _countval.value.countvalue - 1)}
        }
        if(_countval.value.countvalue  ==0){
            triggerToastMessage()
        }
    }

    fun triggerToastMessage(){
        viewModelScope.launch {
            _showmessage
                . emit(CounterEffects.ShowZeroMessage)

        }
    }

}