package com.example.testpracticeapplication.snackbartest

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SnackBarScreen (modifier: Modifier){

    val viewModel: SnackBarViewModel = viewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.state.collect { event ->
            snackbarHostState.showSnackbar(event)
        }
    }

    Scaffold(snackbarHost= { SnackbarHost(snackbarHostState) }) { padding ->
        Button(modifier = Modifier.fillMaxWidth()  .padding(padding) ,
            onClick = {viewModel.onButtonClick()}) {
            Text("Show snackbar")
        }
    }

}