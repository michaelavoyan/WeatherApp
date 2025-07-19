/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.michaelavoyan.weatherapp.data.usecase.GetWeatherByCityUseCaseImpl
import io.michaelavoyan.weatherapp.data.usecase.GetWeatherByCoordinatesUseCaseImpl
import io.michaelavoyan.weatherapp.domain.usecase.GetWeatherByCityUseCase
import io.michaelavoyan.weatherapp.domain.usecase.GetWeatherByCoordinatesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindGetWeatherByCityUseCase(impl: GetWeatherByCityUseCaseImpl): GetWeatherByCityUseCase

    @Binds
    @Singleton
    abstract fun bindGetWeatherByCoordinatesUseCase(impl: GetWeatherByCoordinatesUseCaseImpl): GetWeatherByCoordinatesUseCase
}
