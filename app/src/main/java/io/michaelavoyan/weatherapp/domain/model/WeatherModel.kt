/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.domain.model

interface WeatherModel {
    val temperature: Double
    val feelsLike: Double
    val description: String
    val humidity: Int
    val pressure: Int
    val windSpeed: Double
}
