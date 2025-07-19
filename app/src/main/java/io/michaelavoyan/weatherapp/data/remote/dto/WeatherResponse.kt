/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val name: String,
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val coord: Coord,
)

@Serializable
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

@Serializable
data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int,
)

@Serializable
data class Wind(
    val speed: Double,
)

@Serializable
data class Coord(
    val lon: Double,
    val lat: Double,
)
