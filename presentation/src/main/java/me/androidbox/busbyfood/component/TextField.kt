package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import me.androidbox.busbyfood.ui.theme.BusbyFoodTheme

@Composable
fun TextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = label)
        },
        value = value,
        onValueChange = onValueChanged,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions)
}

@Preview
@Composable
fun PreviewTextField() {
    BusbyFoodTheme {
        TextField("Username", "password", {})
    }
}