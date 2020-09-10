package com.jacktich.forecastmoscowstpeterburg.ui.base.presenter

import com.jacktich.forecastmoscowstpeterburg.ui.base.interactor.MVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.base.view.MVPView

abstract class BasePresenter<V : MVPView, I : MVPInteractor>
internal constructor(
    protected var interactor: I?,
) : MVPPresenter<V, I>
{
    private var view: V? = null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        view = null
        interactor = null
    }
}