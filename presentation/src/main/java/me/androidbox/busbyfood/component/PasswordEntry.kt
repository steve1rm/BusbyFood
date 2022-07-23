package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.androidbox.busbyfood.R

@Composable
fun PasswordEntry(shouldShowLabel: Boolean = false) {

    var passwordText by rememberSaveable { mutableStateOf("") }
    var isPasswordVisibility by rememberSaveable { mutableStateOf(false ) }

    val icon = if (isPasswordVisibility) {
        painterResource(id = R.drawable.ic_visibility_off)
    }
    else {
        painterResource(id = R.drawable.ic_visibility)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Password *", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = passwordText,
            label = {
                if (shouldShowLabel) {
                    Text(text = "Password")
                }
            },
            placeholder = {
                Text(text = "Enter Password")
            },
            onValueChange = { newText ->
                passwordText = newText
            },
            trailingIcon = {
                IconButton(onClick = {
                    isPasswordVisibility = !isPasswordVisibility
                }) {
                    Icon(painter = icon, contentDescription = "icon")
                }
            },
            visualTransformation = if (isPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}

@Composable
@Preview
fun PreviewPasswordEntry() {
    PasswordEntry()
}