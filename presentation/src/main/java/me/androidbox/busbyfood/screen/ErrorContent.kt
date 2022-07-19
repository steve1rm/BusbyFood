package me.androidbox.busbyfood.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.androidbox.busbyfood.R

@Composable
fun ErrorContent(errorMessage: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_dissatisfied),
            contentDescription = "There is no data to show"
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(18.dp),
            text = "There was an issue fetching the data: $errorMessage",
            color = Color.DarkGray,
            fontSize = MaterialTheme.typography.h6.fontSize,
            textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun PreviewErrorContent() {
    ErrorContent(errorMessage = "Network connect error")
}