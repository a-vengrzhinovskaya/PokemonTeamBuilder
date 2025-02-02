package com.example.pokemonteambuilder.di

import com.example.pokemonteambuilder.ui.pokemon.PokemonViewModel
import com.example.pokemonteambuilder.ui.pokemons.PokemonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::PokemonsViewModel)
    viewModelOf(::PokemonViewModel)
}