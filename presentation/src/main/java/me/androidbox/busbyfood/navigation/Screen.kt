package me.androidbox.busbyfood.navigation

sealed class Screen(val route: String) {
    object ListFoodScreen : Screen("listFoodScreen")
    object ComplexSearchDetailScreen: Screen("ComplexSearchDetailScreen")

    fun withArguments(vararg arguments: String): String {
        return buildString {
            append(route)
            arguments.forEach { argument ->
                append("/$argument")
            }
        }
    }
}
