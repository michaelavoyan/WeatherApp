/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.data.extensions

import io.michaelavoyan.weatherapp.data.model.WeatherModelImpl
import io.michaelavoyan.weatherapp.data.remote.dto.WeatherResponse
import io.michaelavoyan.weatherapp.domain.model.WeatherModel

fun WeatherResponse.toWeatherInfo(): WeatherModel =
    WeatherModelImpl(
        temperature = main.temp,
        feelsLike = main.feels_like,
        description = weather.firstOrNull()?.description ?: "N/A",
        humidity = main.humidity,
        pressure = main.pressure,
        windSpeed = wind.speed,
    )
