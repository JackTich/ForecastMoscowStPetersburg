package com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor

import com.jacktich.forecastmoscowstpeterburg.data.api.IWeatherApiHelper
import com.jacktich.forecastmoscowstpeterburg.data.api.WeatherApiHelper
import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class ForecastInteractor
@Inject constructor(
    preferenceHelper: PreferenceHelper,
    weatherApiHelper: IWeatherApiHelper
) : BaseInteractor(preferenceHelper, weatherApiHelper), ForecastMVPInteractor {

    override suspend fun doGetMoscowWeather() = weatherApiHelper.performServerGetMoscowWeather()

    override suspend fun doGetStPetersburgWeather() = weatherApiHelper.performServerGetStPetersburgWeather()

    override fun getSharedPref() = preferenceHelper
}