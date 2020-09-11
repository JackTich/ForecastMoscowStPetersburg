package com.jacktich.forecastmoscowstpeterburg.data.api

import com.jacktich.forecastmoscowstpeterburg.data.responces.GetWeatherResponse
import com.jacktich.forecastmoscowstpeterburg.utils.AppConstants
import retrofit2.http.GET

interface IWeatherApiHelper {

    @GET(AppConstants.URL_MOSCOW)
    suspend fun performServerGetMoscowWeather(): GetWeatherResponse

    @GET(AppConstants.URL_PETERSBURG)
    suspend fun performServerGetStPetersburgWeather(): GetWeatherResponse
}