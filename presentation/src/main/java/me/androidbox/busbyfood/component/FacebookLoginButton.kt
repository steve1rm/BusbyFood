package me.androidbox.busbyfood.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.androidbox.busbyfood.R


@Composable
fun FacebookLoginButton(onLoginClicked: () -> Unit) {
    IconButton(
        modifier = Modifier
            .size(44.dp)
            .background(color = Color.Blue, shape = RoundedCornerShape(10.dp)),
        onClick = {
            onLoginClicked()
        },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_facebook_circle),
            contentDescription = "facebook logo",
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun PreviewFacebookLoginButton() {
    FacebookLoginButton(onLoginClicked = {})
}