package me.androidbox.busbyfood.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.androidbox.busbyfood.component.PasswordEntry

@Composable
fun LoginScreen() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(12.dp)) {
            Text(text = "Email *", fontSize = 16.sp, fontWeight = FontWeight.Bold)

            TextField(modifier = Modifier.fillMaxWidth(), value = "Email Address", onValueChange = { })

            Text(text = "Password *", fontSize = 16.sp, fontWeight = FontWeight.Bold)

            PasswordEntry()

            Text(text = "Forgot your password")

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray),
                onClick = { /*TODO*/ }) {

            }
        }
}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen()
}