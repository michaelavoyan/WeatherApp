/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.domain.usecase

import io.michaelavoyan.weatherapp.domain.model.WeatherModel

interface GetWeatherByCityUseCase {
    suspend fun getWeatherByCity(
        city: String,
        country: String,
    ): WeatherModel
}
