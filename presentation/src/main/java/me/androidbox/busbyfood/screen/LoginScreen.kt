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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.busbyfood.component.*

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
        EmailEntry { emailText ->
            emailEntered = emailText
            println("Email Entered: $emailEntered")
        }
        Spacer(modifier = Modifier.height(40.dp))
        PasswordEntry()
        Spacer(modifier = Modifier.height(40.dp))
        ForgotPasswordLink()
        Spacer(modifier = Modifier.height(24.dp))
        LoginButton(text = "Login", textColor = Color.White, backgroundColor = Color.LightGray) {
            println("Email Entered: $emailEntered")
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Or login with:",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(20.dp))

        LoginOptions(
            onAppleClicked = {
            },
            onTheOneClicked = {
            },
            onFacebookClicked = {
            })

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Don't have an account yet?",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center)

        RegisterButton {

        }
    }
}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen()
}