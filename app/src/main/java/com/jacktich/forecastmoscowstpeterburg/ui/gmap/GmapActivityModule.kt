package com.jacktich.forecastmoscowstpeterburg.ui.gmap

import com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor.GmapInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor.GmapMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.presenter.GmapMVPPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.presenter.GmapPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.view.GmapMVPView
import dagger.Module
import dagger.Provides

@Module
class GmapActivityModule {

    @Provides
    fun provideGmapInteractor(interactor: GmapInteractor): GmapMVPInteractor = interactor

    @Provides
    fun provideGmapPresenter(presenter: GmapPresenter<GmapMVPView, GmapMVPInteractor>): GmapMVPPresenter<GmapMVPView, GmapMVPInteractor> = presenter
}