package com.becker.aston_hw_5_3_navigation_cicerone

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class App : Application() {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    fun getNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    fun getRouter(): Router {
        return cicerone.router
    }

    init {
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}