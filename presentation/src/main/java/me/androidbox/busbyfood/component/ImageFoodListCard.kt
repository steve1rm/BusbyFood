package me.androidbox.busbyfood.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun ImageFoodListCard(imageUrl: String, contentDescription: String, title: String, shouldDisplayGradient: Boolean = true) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 6.dp) {

        Box(modifier = Modifier.height(200.dp)) {
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            /* Gradient so the text can be shown at the bottom */
            if(shouldDisplayGradient) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color.Transparent, Color.DarkGray),
                                startY = 80F
                            )
                        )
                )
            }

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, bottom = 4.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewImageFoodListCard() {
    ImageFoodListCard(
        imageUrl = "",
        contentDescription = "Display the image of food",
        title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
    )
}
