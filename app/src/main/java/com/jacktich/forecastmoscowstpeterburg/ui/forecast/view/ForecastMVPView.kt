package com.jacktich.forecastmoscowstpeterburg.ui.forecast.view

import com.jacktich.forecastmoscowstpeterburg.ui.base.view.MVPView

interface ForecastMVPView: MVPView {
    fun showMessage(message: String)
}