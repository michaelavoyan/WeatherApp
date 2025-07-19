/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.data.usecase

import io.michaelavoyan.weatherapp.domain.model.WeatherModel
import io.michaelavoyan.weatherapp.domain.repository.WeatherRepository
import io.michaelavoyan.weatherapp.domain.usecase.GetWeatherByCityUseCase
import jakarta.inject.Inject

class GetWeatherByCityUseCaseImpl
    @Inject
    constructor(
        private val repo: WeatherRepository,
    ) : GetWeatherByCityUseCase {
        override suspend fun getWeatherByCity(
            city: String,
            country: String,
        ): WeatherModel = repo.getWeatherByCity(city, country)
    }
