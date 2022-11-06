package me.androidbox.busbyfood.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.responsestate.ResponseState

@Composable
fun ListComplexSearchContent(
    responseState: ResponseState<List<ComplexSearchEntity>> = ResponseState.idle,
    lazyPagingItem: LazyPagingItems<ComplexSearchEntity>,
    navController: NavController
) {

    Log.d("LOADSTATE", "${lazyPagingItem.loadState}")

    DisplayContentPaging(listOfComplexSearchEntity = lazyPagingItem, navController = navController)

    when(responseState) {
        is ResponseState.Loading -> {
            LoadingContent()
        }
        is ResponseState.Success -> {
            DisplayContentPaging(listOfComplexSearchEntity = lazyPagingItem, navController = navController)
        }
        is ResponseState.Failure -> {
            ErrorContent(errorMessage = responseState.error.localizedMessage ?: "Unknown Error")
        }
    }
}