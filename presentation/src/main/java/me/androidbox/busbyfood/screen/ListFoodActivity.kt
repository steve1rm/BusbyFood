package me.androidbox.busbyfood.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import me.androidbox.busbyfood.component.ImageFoodListCard
import me.androidbox.busbyfood.viewmodel.FoodListViewModel

@AndroidEntryPoint
class ListFoodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodListViewModel by viewModels<FoodListViewModel>()

        foodListViewModel.fetchComplexSearch()

        lifecycleScope.launch {
            foodListViewModel.complexSearchStateFlow.collect { listOfComplexSearch ->
                println(listOfComplexSearch.count())

                setContent {
                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()) {
                            items(
                                items = listOfComplexSearch,
                                key = { complexSearchEntity ->
                                    complexSearchEntity.id
                                }
                            ) { complexSearchEntity ->
                                ImageFoodListCard(
                                    imageUrl = complexSearchEntity.image,
                                    contentDescription = "Displays pictures of food",
                                    title = complexSearchEntity.title
                                )

                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
