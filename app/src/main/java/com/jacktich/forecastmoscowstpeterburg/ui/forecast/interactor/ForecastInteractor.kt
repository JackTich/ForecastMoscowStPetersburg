package com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor

import com.jacktich.forecastmoscowstpeterburg.data.api.IWeatherApiHelper
import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class ForecastInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    weatherApiHelper: IWeatherApiHelper
) : BaseInteractor(preferenceHelper, weatherApiHelper), ForecastMVPInteractor {

}