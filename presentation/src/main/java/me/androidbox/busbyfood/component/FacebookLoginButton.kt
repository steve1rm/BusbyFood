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
fun FacebookLoginButton(onLoginClicked: () -> Unit) {
    Button(
        contentPadding = ButtonDefaults.ContentPadding,
        onClick = {
            onLoginClicked()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_facebook_circle), contentDescription = "facebook logo")
    }
}

@Composable
@Preview
fun PreviewFacebookLoginButton() {
    FacebookLoginButton(onLoginClicked = {})
}