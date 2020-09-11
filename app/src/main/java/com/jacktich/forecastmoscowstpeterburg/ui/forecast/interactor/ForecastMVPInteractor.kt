package com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor

import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.data.responces.GetWeatherResponse
import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.MVPInteractor

interface ForecastMVPInteractor: MVPInteractor{

    suspend fun doGetMoscowWeather(): GetWeatherResponse
    suspend fun doGetStPetersburgWeather(): GetWeatherResponse
    fun getSharedPref(): PreferenceHelper
}