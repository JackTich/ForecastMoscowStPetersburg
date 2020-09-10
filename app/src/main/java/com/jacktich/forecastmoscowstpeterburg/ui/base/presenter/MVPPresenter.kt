package com.jacktich.forecastmoscowstpeterburg.ui.base.presenter

import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.MVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.base.view.MVPView

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}