package com.dimsun.android.roomz

import android.app.Application
import com.dimsun.android.roomz.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RoomzApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RoomzApplication)
            modules(applicationModule)
        }
    }
}