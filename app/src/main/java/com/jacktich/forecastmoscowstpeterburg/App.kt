package com.jacktich.forecastmoscowstpeterburg

import android.app.Application
import com.jacktich.forecastmoscowstpeterburg.di.components.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App: Application(), HasAndroidInjector {



    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}