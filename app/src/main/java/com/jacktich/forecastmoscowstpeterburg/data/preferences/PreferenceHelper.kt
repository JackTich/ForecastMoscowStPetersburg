package com.jacktich.forecastmoscowstpeterburg.data.preferences

import com.jacktich.forecastmoscowstpeterburg.data.models.ModelCoords
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataCurrentlyDayWeather
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataMainDailyWeather

interface PreferenceHelper {

    fun setCurrEpoch(epoch: Long)

    fun getCurrEpoch(): Long

    fun getCurrCity(): Int

    fun setCurrCity(keyCity: Int)

    fun getCoords(): ModelCoords

    fun setCoords(coords: ModelCoords)

    fun getCurrWeather(): DataCurrentlyDayWeather

    fun setCurrWeather(currWeather: DataCurrentlyDayWeather)

    fun getWeatherList(): DataMainDailyWeather

    fun setWeatherList(data: DataMainDailyWeather)
}