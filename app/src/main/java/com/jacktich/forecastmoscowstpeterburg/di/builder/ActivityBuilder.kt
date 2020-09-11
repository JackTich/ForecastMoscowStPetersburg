package com.jacktich.forecastmoscowstpeterburg.di.builder

import com.jacktich.forecastmoscowstpeterburg.ui.forecast.ForecastActivityModule
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastActivity
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.GmapActivityModule
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.view.GmapActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ForecastActivityModule::class])
    abstract fun bindForecastActivity(): ForecastActivity

    @ContributesAndroidInjector(modules = [GmapActivityModule::class])
    abstract fun bindGmapActivity(): GmapActivity
}