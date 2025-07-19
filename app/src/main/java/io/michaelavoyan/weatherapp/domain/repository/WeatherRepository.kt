/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.domain.repository

import io.michaelavoyan.weatherapp.domain.model.WeatherModel

interface WeatherRepository {
    suspend fun getWeatherByCity(
        city: String,
        country: String,
    ): WeatherModel

    suspend fun getWeatherByCoordinates(
        lat: Double,
        lon: Double,
    ): WeatherModel
}
