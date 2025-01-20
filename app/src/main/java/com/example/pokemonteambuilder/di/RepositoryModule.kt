package com.example.pokemonteambuilder.di

import com.example.pokemonteambuilder.data.repositories.pokemon.PokemonsRepositoryImpl
import com.example.pokemonteambuilder.domain.pokemons.PokemonsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonsRepository> { PokemonsRepositoryImpl(get()) }
}