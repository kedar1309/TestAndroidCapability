package com.example.testpracticeapplication.loginpresentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    private  val _loginstate = MutableStateFlow(LoginState())
        val loginstate = _loginstate

    fun processLoginIntent(loginIntent: LoginIntent){
        when(loginIntent){
             is LoginIntent.onLoginClicked ->{
                  validateLoginCredentials()
            }

            is LoginIntent.EmailChanged ->{
                _loginstate.value=  _loginstate.value.copy(email =loginIntent.email )
            }

           is  LoginIntent.PasswordChanges ->{
               _loginstate.value=    _loginstate.value.copy(password =loginIntent.pass )

            }
        }
    }

    fun validateLoginCredentials(){
        val email = _loginstate.value.email
        val pass = _loginstate.value.password

        when{
            !isValidEmail(email) ->  _loginstate.value= _loginstate.value.copy(error ="Email is not valid", isSubmitted = false )
             pass.length < 6 ->  _loginstate.value=_loginstate.value.copy(error ="password is too short.", isSubmitted = false )
             else ->{
                 _loginstate.value= _loginstate.value.copy(error ="", isSubmitted = true )
             }
        }
    }

    fun isValidEmail(email: String) : Boolean{
      return  email.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
    }



}