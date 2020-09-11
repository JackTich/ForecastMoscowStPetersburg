package com.jacktich.forecastmoscowstpeterburg.ui.forecast.view

import com.jacktich.forecastmoscowstpeterburg.data.responces.DataCurrentlyDayWeather
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataMainDailyWeather
import com.jacktich.forecastmoscowstpeterburg.ui.base.view.MVPView

interface ForecastMVPView: MVPView {
    fun showMessage(message: String)
    fun refreshAdapter(mainDailyWeather: DataMainDailyWeather)
    fun initHeader(currentlyDayWeather: DataCurrentlyDayWeather)
}