package com.jacktich.forecastmoscowstpeterburg.ui.gmap.presenter

import com.jacktich.forecastmoscowstpeterburg.ui.base.presenter.BasePresenter
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor.GmapMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.view.GmapMVPView
import javax.inject.Inject

class GmapPresenter <V : GmapMVPView, I : GmapMVPInteractor> @Inject constructor(
    interactor: I
) : BasePresenter<V, I>(interactor), GmapMVPPresenter<V, I>{
    override fun getPref() = interactor!!.getSharedPref()
}