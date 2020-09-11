package com.jacktich.forecastmoscowstpeterburg.data.api

import com.jacktich.forecastmoscowstpeterburg.data.responces.GetWeatherResponse
import dagger.Provides
import retrofit2.create
import javax.inject.Inject

class WeatherApiHelper @Inject constructor() : IWeatherApiHelper{
    override suspend fun performServerGetMoscowWeather(): GetWeatherResponse =
        ClientHelper().builder.create(IWeatherApiHelper::class.java).performServerGetMoscowWeather()

    override suspend fun performServerGetStPetersburgWeather(): GetWeatherResponse =
        ClientHelper().builder.create(IWeatherApiHelper::class.java).performServerGetStPetersburgWeather()
}