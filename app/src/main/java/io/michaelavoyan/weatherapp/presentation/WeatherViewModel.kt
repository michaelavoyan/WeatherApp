/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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
        private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
        val uiState: StateFlow<UiState> = _uiState

        fun fetchWeatherByCity(
            city: String,
            country: String,
        ) {
            viewModelScope.launch {
                _uiState.value = UiState.Loading
                try {
                    val result = byCityUseCase.getWeatherByCity(city, country)
                    _uiState.value = UiState.Success(result)
                } catch (e: Exception) {
                    _uiState.value = UiState.Error(e.message ?: "Unknown error")
                }
            }
        }

        fun fetchWeatherByCoordinates(
            lat: Double,
            lon: Double,
        ) {
            viewModelScope.launch {
                _uiState.value = UiState.Loading
                try {
                    val result = byCoordinatesUseCase.getWeatherByCoordinates(lat, lon)
                    _uiState.value = UiState.Success(result)
                } catch (e: Exception) {
                    _uiState.value = UiState.Error(e.message ?: "Unknown error")
                }
            }
        }

        fun resetToIdle() {
            _uiState.value = UiState.Idle
        }
    }
