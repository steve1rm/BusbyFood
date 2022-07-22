package me.androidbox.busbyfood.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.androidbox.busbyfood.R

@Composable
fun FacebookLoginButton() {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ }) {

        Icon(painter = painterResource(id = R.drawable.ic_visibility), contentDescription = "facebook login")
    }
}

@Composable
@Preview
fun PreviewFacebookLoginButton() {
    FacebookLoginButton()
}