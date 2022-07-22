package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun LoginButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onLoginClicked: () -> Unit,
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        onClick = { onLoginClicked() }) {

        Text(text = text, color = textColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
@Preview
fun PreviewLoginButton() {
    LoginButton(
        text = "Login",
        textColor = Color.White,
        backgroundColor = Color.DarkGray,
        onLoginClicked = {}
    )
}