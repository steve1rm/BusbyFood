package me.androidbox.busbyfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import me.androidbox.busbyfood.ui.theme.BusbyFoodTheme

@AndroidEntryPoint
class BusbyFoodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusbyFoodTheme {

            }
        }
    }
}

