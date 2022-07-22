package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginOptions(
    onAppleClicked: () -> Unit,
    onTheOneClicked: () -> Unit,
    onFacebookClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 60.dp, end = 60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {

        AppleLoginButton {
            onAppleClicked()
        }

        TheOneLoginButton {
            onTheOneClicked()
        }

        FacebookLoginButton {
            onFacebookClicked()
        }
    }
}

@Composable
@Preview
fun PreviewLoginOptions() {
    LoginOptions(
        onAppleClicked = {},
        onTheOneClicked = {},
        onFacebookClicked = {}
    )
}