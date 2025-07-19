/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.michaelavoyan.weatherapp.domain.model.WeatherModel
import io.michaelavoyan.weatherapp.domain.usecase.GetWeatherByCityUseCase
import io.michaelavoyan.weatherapp.domain.usecase.GetWeatherByCoordinatesUseCase
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class WeatherViewModel
    @Inject
    constructor(
        private val byCityUseCase: GetWeatherByCityUseCase,
        private val byCoordinatesUseCase: GetWeatherByCoordinatesUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<UiState<WeatherModel>>(UiState.Idle)
        val uiState: StateFlow<UiState<WeatherModel>> = _uiState

        fun fetchWeatherByCity(
            city: String,
            country: String,
        ) {
            viewModelScope.launch {
                executeWithUiStateSuspend {
                    byCityUseCase.getWeatherByCity(city, country)
                }
            }
        }

        fun fetchWeatherByCoordinates(
            lat: Double,
            lon: Double,
        ) {
            viewModelScope.launch {
                executeWithUiStateSuspend {
                    byCoordinatesUseCase.getWeatherByCoordinates(lat, lon)
                }
            }
        }

        private suspend fun executeWithUiStateSuspend(block: suspend () -> WeatherModel) {
            _uiState.value = UiState.Loading
            runCatching { block() }
                .onSuccess { _uiState.value = UiState.Success(it) }
                .onFailure { _uiState.value = UiState.Error(it.message ?: "Unknown error") }
        }

        fun resetToIdle() {
            _uiState.value = UiState.Idle
        }
    }
