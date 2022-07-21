package me.androidbox.busbyfood.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import me.androidbox.busbyfood.component.ImageFoodListCard
import me.androidbox.domain.entity.ComplexSearchEntity

@Composable
fun DisplayContent(listOfComplexSearchEntity: List<ComplexSearchEntity>, navController: NavController) {
    LazyColumn {
        items(
            items = listOfComplexSearchEntity,
            key = { complexSearchEntity ->
                complexSearchEntity.id
            }
        ) { complexSearchEntity ->
            ImageFoodListCard(
                imageUrl = complexSearchEntity.image,
                title = complexSearchEntity.title,
                navController = navController,
                context = LocalContext.current
            )
        }
    }
}

@Preview
@Composable
fun PreviewDisplayContent() {
    DisplayContent(listOfComplexSearchEntity = listOf<ComplexSearchEntity>(
        ComplexSearchEntity(
            id = 1,
            title = "Shepherd's Pie all rolled into one",
            image ="https://spoonacular.com/recipeImages/715446-312x231.jpg")),
        navController = NavController(LocalContext.current)
    )
}

