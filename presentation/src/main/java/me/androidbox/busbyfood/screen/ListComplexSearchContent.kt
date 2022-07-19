package me.androidbox.busbyfood.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.responsestate.ResponseState

@Composable
fun ListComplexSearchContent(
    responseState: ResponseState<List<ComplexSearchEntity>>,
    navController: NavController
) {

    when(responseState) {
        is ResponseState.Success -> {
            DisplayContent(listOfComplexSearchEntity = responseState.data, navController = navController)
        }
        is ResponseState.Failure -> {
            ErrorContent(errorMessage = responseState.error.localizedMessage ?: "Unknown Error")
        }
    }
}