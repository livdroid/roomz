package com.dimsun.android.roomz

import android.app.Application
import com.dimsun.android.roomz.di.AppComponent
import com.dimsun.android.roomz.di.ApplicationModule


class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = initDagger(this)
    }

    private fun initDagger(app: App): AppComponent {
        return DaggerAppComponent.builder()
            .appModule(ApplicationModule(app))
            .build()
            .inject(this)
    }
}