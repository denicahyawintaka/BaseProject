package com.example.baseproject

import android.app.Application
import com.example.baseproject.modul.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        // Adding Koin modules to our application
        startKoin {
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }

}