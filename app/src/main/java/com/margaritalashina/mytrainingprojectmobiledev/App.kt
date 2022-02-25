package com.margaritalashina.mytrainingprojectmobiledev

// экземпляр этого класса будет создавать системой при запуске приложения
// также имеет свой жизненный цикл


import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}