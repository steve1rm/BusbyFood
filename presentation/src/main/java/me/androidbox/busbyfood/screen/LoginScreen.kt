package me.androidbox.busbyfood.screen

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
        Text(
            text = "Password *",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
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
            color = Color.Red,
            fontSize = 16.sp,
            textAlign = TextAlign.Center)

        Row(modifier = Modifier.fillMaxWidth()) {

            Button(onClick = { /*TODO*/ }) {

            }
            Button(onClick = { /*TODO*/ }) {

            }
        }
    }
}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen()
}