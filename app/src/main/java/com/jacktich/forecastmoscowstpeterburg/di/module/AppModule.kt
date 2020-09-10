package com.jacktich.forecastmoscowstpeterburg.di.module

import android.app.Application
import android.content.Context
import com.jacktich.forecastmoscowstpeterburg.data.preferences.AppPreferenceHelper
import com.jacktich.forecastmoscowstpeterburg.data.preferences.PreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper =
        appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

}