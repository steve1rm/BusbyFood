package me.androidbox.busbyfood.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.androidbox.busbyfood.R

@Composable
fun TheOneLoginButton(onLoginClicked: () -> Unit) {
    Button(
        modifier = Modifier.size(44.dp),
        contentPadding = PaddingValues(0.dp),
        onClick = {
            onLoginClicked()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_t1_transparent),
            contentDescription = "The One logo",
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun PreviewTheOneLoginButton() {
    TheOneLoginButton(onLoginClicked = {})
}
