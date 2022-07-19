package me.androidbox.busbyfood.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.androidbox.busbyfood.screen.ComplexSearchDetailScreen
import me.androidbox.busbyfood.screen.ListHomeScreen
import me.androidbox.busbyfood.viewmodel.FoodListViewModel

@Composable
fun Navigation(foodListViewModel: FoodListViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ListFoodScreen.route) {
        composable(route = Screen.ListFoodScreen.route) {
            ListHomeScreen(foodListViewModel = foodListViewModel, navController = navController)
        }

        composable(
            route = Screen.ComplexSearchDetailScreen.route + "/{title}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = "Unknown Food"
                }
            )
        ) { navBackStackEntry ->
            ComplexSearchDetailScreen(title = navBackStackEntry.arguments?.getString("title") ?: "Unknown")
        }
    }
}