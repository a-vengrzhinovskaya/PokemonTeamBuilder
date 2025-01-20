package com.example.pokemonteambuilder.di

import com.example.pokemonteambuilder.data.network.PokemonAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit

private val json = Json {
    ignoreUnknownKeys = true
}

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(get<Converter.Factory>())
            .client(get<OkHttpClient>())
            .build()
    }

    single<PokemonAPI> {
        get<Retrofit>().create(PokemonAPI::class.java)
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

    single<Converter.Factory> {
        json.asConverterFactory("application/json".toMediaType())
    }
}