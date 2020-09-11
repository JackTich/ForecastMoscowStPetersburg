package com.jacktich.forecastmoscowstpeterburg.ui.gmap.presenter

import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.ui.base.presenter.MVPPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor.GmapMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.view.GmapMVPView

interface GmapMVPPresenter<V : GmapMVPView, I : GmapMVPInteractor> : MVPPresenter<V, I> {
    fun getPref(): PreferenceHelper
}