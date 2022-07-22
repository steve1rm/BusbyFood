package me.androidbox.busbyfood.component

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.androidbox.busbyfood.R

@Composable
fun TheOneLoginButton(onLoginClicked: () -> Unit) {
    Button(
        contentPadding = ButtonDefaults.ContentPadding,
        onClick = {
            onLoginClicked()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.White)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_t1_transparent), contentDescription = "The One logo")
    }
}

@Composable
@Preview
fun PreviewTheOneLoginButton() {
    TheOneLoginButton(onLoginClicked = {})
}
