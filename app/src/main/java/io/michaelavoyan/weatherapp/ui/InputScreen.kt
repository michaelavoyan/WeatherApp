/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.michaelavoyan.weatherapp.presentation.WeatherViewModel
import io.michaelavoyan.weatherapp.ui.theme.Pink40
import io.michaelavoyan.weatherapp.ui.theme.Purple40

@Composable
fun InputScreen(
    viewModel: WeatherViewModel,
    onResult: () -> Unit,
) {
    var city by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var lat by remember { mutableStateOf("") }
    var lon by remember { mutableStateOf("") }
    var isCityInput by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(
                onClick = { isCityInput = true },
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (isCityInput) Pink40 else Purple40,
                    ),
            ) {
                Text("By City")
            }

            Button(
                onClick = { isCityInput = false },
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isCityInput) Pink40 else Purple40,
                    ),
            ) {
                Text("By Coordinates")
            }
        }

        Spacer(Modifier.height(16.dp))

        if (isCityInput) {
            OutlinedTextField(value = city, onValueChange = { city = it }, label = { Text("City") })
            OutlinedTextField(
                value = country,
                onValueChange = { country = it },
                label = { Text("Country") },
            )
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
//                viewModel.fetchWeatherByCity(city, country)
                viewModel.fetchWeatherByCity("Tel-Aviv", "Israel")
                onResult()
            }) { Text("Get Weather") }
        } else {
            OutlinedTextField(
                value = lat,
                onValueChange = { lat = it },
                label = { Text("Latitude") },
            )
            OutlinedTextField(
                value = lon,
                onValueChange = { lon = it },
                label = { Text("Longitude") },
            )
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
                viewModel.fetchWeatherByCoordinates(lat.toDouble(), lon.toDouble())
//                viewModel.fetchWeatherByCoordinates("40.741895".toDouble(), "-73.989308".toDouble())
                onResult()
            }) { Text("Get Weather") }
        }
    }
}
