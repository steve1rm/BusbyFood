package me.androidbox.busbyfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.androidbox.busbyfood.navigation.Navigation
import me.androidbox.busbyfood.ui.theme.BusbyFoodTheme
import me.androidbox.busbyfood.viewmodel.FoodListViewModel
import me.androidbox.busbyfood.viewmodel.LoginScreenViewModel

@AndroidEntryPoint
class BusbyFoodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodListViewModel by viewModels<FoodListViewModel>()
        val loginScreenViewModel by viewModels<LoginScreenViewModel>()

        setContent {
            BusbyFoodTheme {
                Navigation(foodListViewModel = foodListViewModel)
            }
        }
    }
}

