package com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor

import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class GmapInteractor @Inject constructor(
    preferenceHelper: PreferenceHelper
) : BaseInteractor(preferenceHelper), GmapMVPInteractor{
    override fun getSharedPref() = preferenceHelper
}