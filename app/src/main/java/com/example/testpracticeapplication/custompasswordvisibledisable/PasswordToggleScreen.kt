package com.example.testpracticeapplication.custompasswordvisibledisable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.testpracticeapplication.R

@Composable
fun PasswordToggleScreen(modifier: Modifier = Modifier) {

    var entertext by remember{ mutableStateOf("") }
    var isHidden by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
            OutlinedTextField(
                 modifier = Modifier.weight(1f),
                value = entertext, onValueChange = {entertext= it},
                visualTransformation = if(isHidden) PasswordVisualTransformation() else VisualTransformation.None
            )
            Icon(modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .size(40.dp)
                .clickable{
                isHidden = !isHidden
            },
                painter = if(isHidden)
                painterResource(R.drawable.hidden) else painterResource(R.drawable.visual),
                contentDescription = "Show/ Hide password")
        }

    }

}