package me.androidbox.busbyfood.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(): ViewModel() {

    var usernameState by mutableStateOf("")
        private set
    var passwordState by mutableStateOf("")
        private set

    fun usernameOnChanged(newText: String) {
        usernameState = newText
    }

    fun passwordOnChanged(newText: String) {
        passwordState = newText
    }
}