package com.example.testpracticeapplication.likeunlickepresentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LikeUnlikeScreen (modifier: Modifier){

    val viewModel: LikeUnlikeViewModel = viewModel()
    val state by viewModel.likestate.collectAsStateWithLifecycle()

    Column(modifier= Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = if(state.isLiked) "Liked" else "UnLiked")
        Button(onClick = {viewModel.setLikeStatus()},
            colors = ButtonDefaults.buttonColors(containerColor = if(state.isLiked) Color.Red else Color.Gray)) {
            Text("Like / Unlike Button")
        }

    }

}