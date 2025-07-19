/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.android.AndroidEntryPoint
import io.michaelavoyan.weatherapp.presentation.UiState
import io.michaelavoyan.weatherapp.presentation.WeatherViewModel
import io.michaelavoyan.weatherapp.ui.InputScreen
import io.michaelavoyan.weatherapp.ui.WeatherScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(viewModel)
        }
    }
}

@Composable
fun MainContent(viewModel: WeatherViewModel) {
    val state = viewModel.uiState.collectAsState().value

    Surface(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is UiState.Idle -> {
                InputScreen(viewModel = viewModel) {}
            }

            is UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    InputScreen(viewModel = viewModel) {}
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }

            is UiState.Success -> {
                WeatherScreen(data = state.data, viewModel = viewModel)
            }

            is UiState.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Error: ${state.message}")
                }
            }
        }
    }

    val context = LocalContext.current
    BackHandler {
        if (state is UiState.Error) {
            viewModel.resetToIdle()
        } else {
            (context as? Activity)?.finish()
        }
    }
}
