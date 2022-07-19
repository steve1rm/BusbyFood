package me.androidbox.busbyfood.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import me.androidbox.busbyfood.viewmodel.FoodListViewModel

@Composable
fun ListHomeScreen(
    foodListViewModel: FoodListViewModel
) {
    foodListViewModel.fetchComplexSearch()

    val listOfComplexSearch by foodListViewModel.complexSearchStateFlow.collectAsState()
    val rememberScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = rememberScaffoldState,
        topBar = {
            TopAppBar {
                Text(text = "Busby Food", color = Color.White, fontSize = 24.sp)
            }
        },
        content = {

        }
    )
}