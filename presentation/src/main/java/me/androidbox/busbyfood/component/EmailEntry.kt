package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun EmailEntry(
    shouldShowLabel: Boolean = false,
    onEmailEntered: (emailText: String) -> Unit) {

    var emailText by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Email *",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = emailText,
            label = {
                if(shouldShowLabel) {
                    Text(text = "Email")
                }
            },
            placeholder = {
                Text(text = "Email Address")
            },
            onValueChange = { newText ->
                emailText = newText
                onEmailEntered(emailText)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }
}

@Composable
@Preview
fun PreviewEmailEntry() {
    EmailEntry(onEmailEntered = {})
}