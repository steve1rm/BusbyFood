package me.androidbox.busbyfood.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.busbyfood.component.EmailEntry
import me.androidbox.busbyfood.component.ForgotPasswordLink
import me.androidbox.busbyfood.component.LoginButton
import me.androidbox.busbyfood.component.PasswordEntry

@Composable
fun LoginScreen() {

    var emailEntered by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(12.dp)) {

        Spacer(modifier = Modifier.height(80.dp))
        Text(text = "Email *", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        EmailEntry { emailText ->
            emailEntered = emailText
            println("Email Entered: $emailEntered")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Password *", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        PasswordEntry()
        Spacer(modifier = Modifier.height(40.dp))
        ForgotPasswordLink()
        Spacer(modifier = Modifier.height(24.dp))
        LoginButton(text = "Login", textColor = Color.White, backgroundColor = Color.LightGray) {
            println("Email Entered: $emailEntered")
        }
    }
}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen()
}