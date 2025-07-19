/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.presentation

import io.michaelavoyan.weatherapp.domain.model.WeatherModel

sealed class UiState {
    object Idle : UiState()

    object Loading : UiState()

    data class Success(
        val data: WeatherModel,
    ) : UiState()

    data class Error(
        val message: String,
    ) : UiState()
}
