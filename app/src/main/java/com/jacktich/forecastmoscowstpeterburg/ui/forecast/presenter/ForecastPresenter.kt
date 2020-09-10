package com.jacktich.forecastmoscowstpeterburg.ui.forecast.presenter

import com.jacktich.forecastmoscowstpeterburg.ui.base.presenter.BasePresenter
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor.ForecastMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastMVPView
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ForecastPresenter<V : ForecastMVPView, I : ForecastMVPInteractor>
@Inject constructor(
    interactor: I
) : BasePresenter<V, I>(interactor),
    ForecastMVPPresenter<V, I>, CoroutineScope {

    private val mainJob = SupervisorJob()
    private lateinit var jobMoscow: Job
    private lateinit var jobStPetersburg: Job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + mainJob

    private val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        getView()?.showMessage("Ошибка подключения к серверу")
        throwable.printStackTrace()
    }

}