/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.michaelavoyan.weatherapp.domain.model.WeatherModel
import io.michaelavoyan.weatherapp.presentation.WeatherViewModel

@Composable
fun WeatherScreen(
    data: WeatherModel,
    viewModel: WeatherViewModel,
) {
    BackHandler {
        viewModel.resetToIdle()
    }
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        Text(
            text = "Weather",
            style = MaterialTheme.typography.titleLarge,
            modifier =
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
        )

        val items =
            listOf(
                "Temperature" to "${data.temperature} °C",
                "Feels Like" to "${data.feelsLike} °C",
                "Description" to data.description,
                "Humidity" to "${data.humidity}%",
                "Pressure" to "${data.pressure} hPa",
                "Wind Speed" to "${data.windSpeed} m/s",
            )

        items.forEach { (label, value) ->
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = label, style = MaterialTheme.typography.bodyMedium)
                Text(text = value, style = MaterialTheme.typography.bodyMedium)
            }
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
        }
    }
}
