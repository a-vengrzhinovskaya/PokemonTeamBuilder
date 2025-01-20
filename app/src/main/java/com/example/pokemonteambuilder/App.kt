package com.example.pokemonteambuilder

import android.app.Application
import com.example.pokemonteambuilder.di.networkModule
import com.example.pokemonteambuilder.di.repositoryModule
import com.example.pokemonteambuilder.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}