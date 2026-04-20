package com.example.testpracticeapplication.likeunlickepresentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LikeUnlikeViewModel: ViewModel() {

    private val _likestate = MutableStateFlow(LikeState())
    val likestate = _likestate

    fun setLikeStatus(){
        viewModelScope.launch {
            _likestate.update { it.copy(isLiked = !it.isLiked) }
        }
    }
}