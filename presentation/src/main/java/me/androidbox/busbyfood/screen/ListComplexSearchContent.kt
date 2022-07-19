package me.androidbox.busbyfood.screen

import androidx.compose.runtime.Composable
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.responsestate.ResponseState

@Composable
fun ListComplexSearchContent(
    responseState: ResponseState<List<ComplexSearchEntity>>
) {

    when(responseState) {
        is ResponseState.Success -> {
            // Display content
        }
        is ResponseState.Failure -> {
            // Display error content
        }
    }
}