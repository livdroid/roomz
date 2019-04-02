package com.dimsun.android.roomz.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return application
    }
}

@Singleton
@Component(modules = [ ApplicationModule::class])
interface AppComponent {
    fun application(): Application
}