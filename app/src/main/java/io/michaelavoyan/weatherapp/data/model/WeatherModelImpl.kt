/**
 * Created by Michael Avoyan on 19/07/2025.
 *
 * Copyright 2022 Velocity Career Labs inc.
 * SPDX-License-Identifier: Apache-2.0
 */

package io.michaelavoyan.weatherapp.data.model

import io.michaelavoyan.weatherapp.domain.model.WeatherModel

class WeatherModelImpl(
    override val name: String,
    override val temperature: Double,
    override val feelsLike: Double,
    override val description: String,
    override val humidity: Int,
    override val pressure: Int,
    override val windSpeed: Double,
) : WeatherModel
