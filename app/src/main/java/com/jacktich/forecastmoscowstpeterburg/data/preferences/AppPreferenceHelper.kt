package com.jacktich.forecastmoscowstpeterburg.data.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import com.jacktich.forecastmoscowstpeterburg.utils.AppConstants.PREF_NAME

class AppPreferenceHelper  @Inject constructor(context: Context) : PreferenceHelper {

    private val prefFileName: String = PREF_NAME
    private val mPref: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
}