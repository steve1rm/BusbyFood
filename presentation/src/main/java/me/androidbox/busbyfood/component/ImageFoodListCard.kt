package me.androidbox.busbyfood.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import me.androidbox.busbyfood.navigation.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImageFoodListCard(imageUrl: String, title: String, shouldDisplayGradient: Boolean = true, navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = { navController.navigate(Screen.ComplexSearchDetailScreen.withArguments(title))},
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
                contentDescription = "Display picture of food item",
                contentScale = ContentScale.Crop
            )

            /* Gradient so the text can be shown at the bottom */
            if(shouldDisplayGradient) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(ContentAlpha.high))
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
        imageUrl = "https://spoonacular.com/recipeImages/715446-312x231.jpg",
        title = "Cauliflower, Brown Rice, and Vegetable Fried Rice",
        navController = NavController(LocalContext.current)
    )
}
