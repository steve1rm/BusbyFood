package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterButton(
    onRegisterClicked: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onRegisterClicked() }) {

        Text(text = "REGISTER NOW", color = Color.Black)
    }
}

@Composable
@Preview
fun PreviewRegisterButton() {
    RegisterButton(onRegisterClicked = {})
}