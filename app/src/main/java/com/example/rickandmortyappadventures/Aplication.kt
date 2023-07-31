package com.example.rickandmortyappadventures

import android.app.Application
import com.example.rickandmortyappadventures.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Application)
            modules(AppModule)
        }
    }
}