package com.example.listra

import android.app.Application
import com.example.listra.di.AppComponent
import com.example.listra.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)

    }
}