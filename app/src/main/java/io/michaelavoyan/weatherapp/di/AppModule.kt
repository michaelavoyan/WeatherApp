/**
 * Created by Michael Avoyan on 19/07/2025.
 */

package io.michaelavoyan.weatherapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.michaelavoyan.weatherapp.data.remote.api.WeatherApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    /**
     * TODO: In production, the API key should be injected securely via CI secrets.
     */
    private const val API_KEY = "3782371bf3315146c05af74672dc8537"

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(OkHttpClient.Builder().build())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    @Named("OpenWeatherApiKey")
    fun provideApiKey(): String = API_KEY
}
