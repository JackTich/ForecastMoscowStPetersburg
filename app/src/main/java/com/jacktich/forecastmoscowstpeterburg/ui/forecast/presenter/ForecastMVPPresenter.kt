package com.jacktich.forecastmoscowstpeterburg.ui.forecast.presenter

import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.ui.base.presenter.MVPPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor.ForecastMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastMVPView

interface ForecastMVPPresenter<V : ForecastMVPView, I : ForecastMVPInteractor> :
    MVPPresenter<V, I> {

    fun initForecastActivity(keyCity: Int)
    fun getPref(): PreferenceHelper
    fun cancelStPetJob()
    fun cancelMoscowJob()
}