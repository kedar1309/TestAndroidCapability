package com.example.testpracticeapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testpracticeapplication.counterpresentation.CounterEffects
import com.example.testpracticeapplication.counterpresentation.CounterViewModel
import com.example.testpracticeapplication.counterpresentation.UserIntent
import com.example.testpracticeapplication.custompasswordvisibledisable.PasswordToggleScreen
import com.example.testpracticeapplication.debouncesearch.SearchScreen
import com.example.testpracticeapplication.likeunlickepresentation.LikeUnlikeScreen
import com.example.testpracticeapplication.loginpresentation.LoginIntent
import com.example.testpracticeapplication.loginpresentation.LoginViewModel
import com.example.testpracticeapplication.timerpresentation.TimerScreen
import com.example.testpracticeapplication.ui.theme.TestPracticeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestPracticeApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    /*CounterComputation(
                        modifier = Modifier.padding(innerPadding)
                    )*/
                  //  SearchScreen(modifier = Modifier.padding(innerPadding))
                   // TimerScreen(modifier = Modifier.padding(innerPadding))
                   // LikeUnlikeScreen(modifier = Modifier.padding(innerPadding))
                    PasswordToggleScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CounterComputation( modifier: Modifier = Modifier) {
    val viewmodel: CounterViewModel = viewModel()
    val state by viewmodel.countval.collectAsStateWithLifecycle()
    val context: Context = LocalContext.current

    LaunchedEffect(Unit) {
        viewmodel.showmessage.collect { collect ->
            when(collect){
                CounterEffects.ShowZeroMessage -> {
                    Toast.makeText(context, "Negative value not allowed", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
    Column(modifier= Modifier.fillMaxSize().padding(top = 32.dp), verticalArrangement = Arrangement.Center) {
        Text("Counter value = ${state.countvalue}")
        Spacer(modifier= Modifier.height(8.dp))
        Button(modifier = Modifier.fillMaxWidth().testTag("Add"), onClick = {viewmodel.processIntent(UserIntent.AddClicked)}) {
            Text(text = "Add")
        }
        Spacer(modifier= Modifier.height(8.dp))
        Button(modifier = Modifier.fillMaxWidth().testTag("Minus"),onClick = {viewmodel.processIntent(UserIntent.MinusClicked)}) {
            Text(text = "Minus")
        }

    }

}


@Composable
fun LoginScreen(modifier: Modifier = Modifier){
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.loginstate.collectAsStateWithLifecycle()
    val email by remember { mutableStateOf("") }
    val context: Context = LocalContext.current
    Column(modifier= Modifier.fillMaxSize().padding(top = 32.dp), verticalArrangement = Arrangement.Center) {
        Text("Login Screen")
        Spacer(modifier= Modifier.height(8.dp))

        OutlinedTextField(modifier = Modifier.fillMaxWidth() .padding(start = 8.dp, end = 8.dp).testTag("EmailTag"),value =state.email, onValueChange = {viewModel.processLoginIntent(
            LoginIntent.EmailChanged(it))}, label = {Text("Email Id")} ,  )

        Spacer(modifier= Modifier.height(8.dp))

        OutlinedTextField(modifier = Modifier.fillMaxWidth() .padding(start = 8.dp, end = 8.dp).testTag("PasswordTag"),value =state.password, onValueChange = {viewModel.processLoginIntent(
            LoginIntent.PasswordChanges(it))}, label = {Text("Password")} , visualTransformation = PasswordVisualTransformation() )

        Spacer(modifier= Modifier.height(8.dp))

        Button(modifier = Modifier.fillMaxWidth().testTag("Submitbutton"),onClick = {viewModel.processLoginIntent(
            LoginIntent.onLoginClicked)}) {
            Text(text = "Login")
        }
        Spacer(modifier= Modifier.height(8.dp))

        if(!state.error.equals("")){
            Text(text = state.error)
        }

        if(state.isSubmitted){
            Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show()
        }
    }

}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestPracticeApplicationTheme {
      //  Greeting("Android")
    }
}