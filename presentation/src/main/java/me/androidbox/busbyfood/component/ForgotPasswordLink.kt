package me.androidbox.busbyfood.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordLink() {
    ClickableText(
        modifier = Modifier.fillMaxWidth(),
        text = AnnotatedString(
            text = "Forgot your password?",
            spanStyle = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Light,
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            ),
            paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
        ),
        onClick = {
            println("Character that has been clicked: $it")
        })
}

@Composable
@Preview
fun PreviewForgotPasswordLink() {
    ForgotPasswordLink()
}
