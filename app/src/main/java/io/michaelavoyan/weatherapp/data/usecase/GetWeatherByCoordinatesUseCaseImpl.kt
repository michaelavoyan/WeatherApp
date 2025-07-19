/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.data.usecase

import io.michaelavoyan.weatherapp.domain.model.WeatherModel
import io.michaelavoyan.weatherapp.domain.repository.WeatherRepository
import io.michaelavoyan.weatherapp.domain.usecase.GetWeatherByCoordinatesUseCase
import jakarta.inject.Inject

class GetWeatherByCoordinatesUseCaseImpl
    @Inject
    constructor(
        private val repo: WeatherRepository,
    ) : GetWeatherByCoordinatesUseCase {
        override suspend fun getWeatherByCoordinates(
            lat: Double,
            lon: Double,
        ): WeatherModel = repo.getWeatherByCoordinates(lat, lon)
    }
