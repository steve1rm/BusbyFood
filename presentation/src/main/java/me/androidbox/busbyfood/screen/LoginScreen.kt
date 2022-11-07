package me.androidbox.busbyfood.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import me.androidbox.busbyfood.component.TextField
import me.androidbox.busbyfood.ui.theme.BusbyFoodTheme
import me.androidbox.busbyfood.viewmodel.LoginScreenViewModel

@Composable
fun LoginScreen(loginScreenViewModel: LoginScreenViewModel) {

    Column {
        TextField(
            label = "Username",
            value = loginScreenViewModel.usernameState,
            onValueChanged = { newText ->
                loginScreenViewModel.usernameOnChanged(newText)
            }
        )
        TextField(
            label = "Password",
            value = loginScreenViewModel.usernameState,
            onValueChanged = { newText ->
                loginScreenViewModel.passwordOnChanged(newText)
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = loginScreenViewModel.usernameState.isNotBlank() && loginScreenViewModel.passwordState.isNotBlank(),
            onClick = { }) {
            Text(text = "Submit")
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    BusbyFoodTheme {
        LoginScreen(LoginScreenViewModel())
    }
}