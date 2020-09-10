package com.jacktich.forecastmoscowstpeterburg.ui.forecast

import com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor.ForecastInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor.ForecastMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.presenter.ForecastMVPPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.presenter.ForecastPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastMVPView
import dagger.Module
import dagger.Provides

@Module
class ForecastActivityModule {

    @Provides
    internal fun provideForecastInteractor(interactor: ForecastInteractor): ForecastMVPInteractor =
        interactor

    @Provides
    internal fun provideForecastPresenter(presenter: ForecastPresenter<ForecastMVPView, ForecastMVPInteractor>): ForecastMVPPresenter<ForecastMVPView, ForecastMVPInteractor> =
        presenter
}