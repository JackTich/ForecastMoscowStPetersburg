package com.jacktich.forecastmoscowstpeterburg.ui.base.interactor

import com.jacktich.forecastmoscowstpeterburg.data.api.IWeatherApiHelper
import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper

open class BaseInteractor(): MVPInteractor {
    private lateinit var weatherApiHelper: IWeatherApiHelper
    private lateinit var preferenceHelper: PreferenceHelper

    constructor(
        preferenceHelper: PreferenceHelper,
        weatherApiHelper: IWeatherApiHelper
    ) : this() {
        this.preferenceHelper = preferenceHelper
        this.weatherApiHelper = weatherApiHelper
    }
}