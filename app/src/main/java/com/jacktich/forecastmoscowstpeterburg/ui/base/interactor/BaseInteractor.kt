package com.jacktich.forecastmoscowstpeterburg.ui.base.interactor

import com.jacktich.forecastmoscowstpeterburg.data.api.IWeatherApiHelper
import com.jacktich.forecastmoscowstpeterburg.data.api.WeatherApiHelper
import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper

open class BaseInteractor(): MVPInteractor {
    protected lateinit var weatherApiHelper: IWeatherApiHelper
    protected lateinit var preferenceHelper: PreferenceHelper

    constructor(
        preferenceHelper: PreferenceHelper,
        weatherApiHelper: IWeatherApiHelper
    ) : this() {
        this.preferenceHelper = preferenceHelper
        this.weatherApiHelper = weatherApiHelper
    }

    constructor(
        preferenceHelper: PreferenceHelper
    ): this(){
        this.preferenceHelper = preferenceHelper
    }
}