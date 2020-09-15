package com.firmfreez.android.spidergrouptest.di

import android.app.Application

class App: Application() {

    var component = DaggerAppComponent.create()

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        lateinit var instance: App
    }
}