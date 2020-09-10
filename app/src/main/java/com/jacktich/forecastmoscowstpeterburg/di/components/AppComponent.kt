package com.jacktich.forecastmoscowstpeterburg.di.components

import android.app.Application
import com.jacktich.forecastmoscowstpeterburg.App
import com.jacktich.forecastmoscowstpeterburg.di.builder.ActivityBuilder
import com.jacktich.forecastmoscowstpeterburg.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}