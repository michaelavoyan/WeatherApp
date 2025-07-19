/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.domain.usecase

import io.michaelavoyan.weatherapp.domain.model.WeatherModel

interface GetWeatherByCoordinatesUseCase {
    suspend fun getWeatherByCoordinates(
        lat: Double,
        lon: Double,
    ): WeatherModel
}