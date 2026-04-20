package com.example.testpracticeapplication.timerpresentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.Timer

@Composable
fun TimerScreen (modifier: Modifier){

    val viewmodel : TimerViewModel = viewModel()

    val state by viewmodel.timervalue.collectAsStateWithLifecycle()
    var selectedButton by remember { mutableStateOf<String?>(null) }

    Column(modifier= Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text( text = "$state", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.Blue)

        Spacer(modifier= Modifier.height(8.dp))

        Button(modifier= Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedButton == "Play") Color.Blue else Color.Gray
            ),
            onClick = {
            selectedButton = "Play"
            viewmodel.startTimerFrom(60)}) {Text(text = "Play")
        }

        Spacer(modifier= Modifier.height(8.dp))

        Button(modifier= Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedButton == "Pause") Color.Blue else Color.Gray
            ),
            onClick = {viewmodel.pauseTimer()
            selectedButton = "Pause"
        }) {Text(text = "Pause") }

        Spacer(modifier= Modifier.height(8.dp))

        Button(modifier= Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedButton == "Reset") Color.Blue else Color.Gray
            ),
            onClick = {viewmodel.resetTimer()
            selectedButton = "Reset"
        }) {Text(text = "Reset") }


    }

}