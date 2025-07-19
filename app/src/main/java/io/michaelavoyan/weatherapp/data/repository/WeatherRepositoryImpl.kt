/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.data.repository

import io.michaelavoyan.weatherapp.data.extensions.toWeatherInfo
import io.michaelavoyan.weatherapp.data.remote.api.WeatherApi
import io.michaelavoyan.weatherapp.domain.model.WeatherModel
import io.michaelavoyan.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject
import javax.inject.Named

class WeatherRepositoryImpl
    @Inject
    constructor(
        private val api: WeatherApi,
        @Named("OpenWeatherApiKey") private val apiKey: String,
    ) : WeatherRepository {
        override suspend fun getWeatherByCity(
            city: String,
            country: String,
        ): WeatherModel {
            val response = api.getWeatherByCity("$city,$country", apiKey)
            return response.toWeatherInfo()
        }

        override suspend fun getWeatherByCoordinates(
            lat: Double,
            lon: Double,
        ): WeatherModel {
            val response = api.getWeatherByCoordinates(lat, lon, apiKey)
            return response.toWeatherInfo()
        }
    }
