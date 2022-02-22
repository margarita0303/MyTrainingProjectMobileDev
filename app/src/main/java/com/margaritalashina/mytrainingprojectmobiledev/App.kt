package com.margaritalashina.mytrainingprojectmobiledev

import android.app.Application
import com.margaritalashina.mytrainingprojectmobiledev.repository.AuthRepository
import timber.log.Timber

// экземпляр этого класса будет создавать системой при запуске приложения
// также имеет свой жизненный цикл

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