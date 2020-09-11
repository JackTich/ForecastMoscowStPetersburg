package com.jacktich.forecastmoscowstpeterburg.ui.forecast.presenter

import com.jacktich.forecastmoscowstpeterburg.data.models.ModelCoords
import com.jacktich.forecastmoscowstpeterburg.ui.base.presenter.BasePresenter
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor.ForecastMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastActivity
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastMVPView
import kotlinx.coroutines.*
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
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

    private val handler = CoroutineExceptionHandler { _, throwable ->
        getView()?.showMessage("Ошибка подключения к серверу")
        throwable.printStackTrace()
    }

    override fun initForecastActivity(keyCity: Int) {
        interactor?.let {
            cancelAllJob()
            when (keyCity) {
                ForecastActivity.KEY_MOSCOW -> {
                    jobMoscow = launch(handler) {
                        val getWeatherResponse = withContext(Dispatchers.IO) {
                            it.doGetMoscowWeather()
                        }
                        getPref().apply {
                            setCurrEpoch(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond())
                            setCurrWeather(getWeatherResponse.currently)
                            setWeatherList(getWeatherResponse.daily)
                            setCoords(ModelCoords(latitude = getWeatherResponse.latitude, longitude = getWeatherResponse.longitude))
                        }
                        getView()?.apply {
                            refreshAdapter(getWeatherResponse.daily)
                            initHeader(getWeatherResponse.currently)
                        }
                    }
                }
                ForecastActivity.KEY_ST_PETERSBURG -> {
                    jobStPetersburg = launch(handler) {
                        val getWeatherResponse = withContext(Dispatchers.IO) {
                            it.doGetStPetersburgWeather()
                        }
                        getPref().apply {
                            setCurrEpoch(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond())
                            setCurrWeather(getWeatherResponse.currently)
                            setWeatherList(getWeatherResponse.daily)
                            setCoords(ModelCoords(latitude = getWeatherResponse.latitude, longitude = getWeatherResponse.longitude))
                        }
                        getView()?.apply {
                            refreshAdapter(getWeatherResponse.daily)
                            initHeader(getWeatherResponse.currently)
                        }
                    }
                }
            }
        }
    }

    override fun getPref() = interactor!!.getSharedPref()

    override fun cancelStPetJob(){
        if (this::jobStPetersburg.isInitialized && jobStPetersburg.isActive){
            jobStPetersburg.cancel()
        }
    }
    override fun cancelMoscowJob(){
        if (this::jobMoscow.isInitialized && jobMoscow.isActive){
            jobMoscow.cancel()
        }
    }

    private fun cancelAllJob(){
        cancelStPetJob()
        cancelMoscowJob()
    }

}