package com.example.testpracticeapplication.debouncesearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SearchScreen (modifier: Modifier){

    val viewmodel : SearchViewModel = viewModel()
    val state by viewmodel.state.collectAsStateWithLifecycle()

    val q by viewmodel.queryvalue.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize().padding(all =  16.dp)){

        OutlinedTextField(
            modifier= Modifier.fillMaxWidth().testTag("searchTextfield"),
            value = q,
            onValueChange = {viewmodel.onQueryChanges(it)},
            label = {Text("Search Query")})

        when {
            state.isLoadin -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }
            }
            state.error != null->{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text("Error")
                }
            }
            else -> {
                var res = state.list
                LazyColumn {
                        items(res){
                            Text("$it")
                        }}
            }
        }
    }

}



