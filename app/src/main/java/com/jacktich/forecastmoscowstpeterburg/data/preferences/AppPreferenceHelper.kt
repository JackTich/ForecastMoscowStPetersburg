package com.jacktich.forecastmoscowstpeterburg.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.jacktich.forecastmoscowstpeterburg.data.models.ModelCoords
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataCurrentlyDayWeather
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataMainDailyWeather
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastActivity
import javax.inject.Inject
import com.jacktich.forecastmoscowstpeterburg.utils.AppConstants.PREF_NAME

class AppPreferenceHelper @Inject constructor(context: Context) : PreferenceHelper {

    companion object {
        const val PREF_KEY_CURR_WEATHER = "PREF_KEY_CURR_WEATHER"
        const val PREF_KEY_LIST_WEATHER = "PREF_KEY_LIST_WEATHER"
        const val PREF_KEY_CURR_EPOCH = "PREF_KEY_CURR_EPOCH"
        const val PREF_KEY_CURR_CITY = "PREF_KEY_CURR_CITY"
        const val PREF_COORDS = "PREF_COORDS"
    }

    private val prefFileName: String = PREF_NAME
    private val mPref: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)


    override fun setCurrEpoch(epoch: Long) {
        mPref.edit().putLong(PREF_KEY_CURR_EPOCH, epoch).apply()
    }

    override fun getCurrEpoch(): Long = mPref.getLong(PREF_KEY_CURR_EPOCH, -1)

    override fun getCurrCity(): Int  = mPref.getInt(PREF_KEY_CURR_CITY, ForecastActivity.KEY_ST_PETERSBURG)

    override fun setCurrCity(keyCity: Int) {
        mPref.edit().putInt(PREF_KEY_CURR_CITY, keyCity).apply()
    }

    override fun getCoords(): ModelCoords = Gson().fromJson(
        mPref.getString(PREF_COORDS, ""), ModelCoords::class.java
    )

    override fun setCoords(coords: ModelCoords) {
        val jsonStr = Gson().toJson(coords)!!
        mPref.edit().putString(PREF_COORDS, jsonStr).apply()
    }

    override fun getCurrWeather(): DataCurrentlyDayWeather = Gson().fromJson(
        mPref.getString(PREF_KEY_CURR_WEATHER, ""), DataCurrentlyDayWeather::class.java
    )

    override fun setCurrWeather(currWeather: DataCurrentlyDayWeather) {
        val jsonStr = Gson().toJson(currWeather)!!
        mPref.edit().putString(PREF_KEY_CURR_WEATHER, jsonStr).apply()
    }

    override fun getWeatherList(): DataMainDailyWeather = Gson().fromJson(
        mPref.getString(PREF_KEY_LIST_WEATHER, ""), DataMainDailyWeather::class.java
    )


    override fun setWeatherList(data: DataMainDailyWeather) {
        val jsonStr = Gson().toJson(data)!!
        mPref.edit().putString(PREF_KEY_LIST_WEATHER, jsonStr).apply()
    }
}