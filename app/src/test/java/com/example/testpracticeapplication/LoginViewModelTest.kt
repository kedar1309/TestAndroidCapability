package com.example.testpracticeapplication

import com.example.testpracticeapplication.loginpresentation.LoginIntent
import com.example.testpracticeapplication.loginpresentation.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    private  lateinit var viewModelTest: LoginViewModel

    @Before
    fun Setup(){
        viewModelTest = LoginViewModel()
   }

    @Test
    fun invalide_mail_id_test(){
        viewModelTest.processLoginIntent(LoginIntent.EmailChanged("abcd"))
        viewModelTest.processLoginIntent(LoginIntent.PasswordChanges("abcdeftgg"))
        viewModelTest.processLoginIntent(LoginIntent.onLoginClicked)
        assertEquals("Invalid email id", viewModelTest.loginstate.value.error )
    }

    @Test
    fun invalide_password_id_test(){
        viewModelTest.processLoginIntent(LoginIntent.EmailChanged("abcd@gmail.com"))
        viewModelTest.processLoginIntent(LoginIntent.PasswordChanges("abc"))
        viewModelTest.processLoginIntent(LoginIntent.onLoginClicked)
        assertEquals("Password is too short", viewModelTest.loginstate.value.error )
    }

    @Test
    fun valide_mail_id_test() {
        viewModelTest.processLoginIntent(LoginIntent.EmailChanged("abcd@gmail.com"))
        viewModelTest.processLoginIntent(LoginIntent.PasswordChanges("abcdeftgg"))
        viewModelTest.processLoginIntent(LoginIntent.onLoginClicked)
        assertEquals("", viewModelTest.loginstate.value.error)
    }
}