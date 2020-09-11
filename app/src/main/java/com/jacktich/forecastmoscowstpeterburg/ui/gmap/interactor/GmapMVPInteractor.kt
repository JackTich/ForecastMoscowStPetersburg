package com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor

import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.MVPInteractor

interface GmapMVPInteractor: MVPInteractor {
    fun getSharedPref(): PreferenceHelper
}