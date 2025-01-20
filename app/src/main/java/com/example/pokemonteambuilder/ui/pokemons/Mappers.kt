package com.example.pokemonteambuilder.ui.pokemons

import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon

fun Pokemon.toPokemonUI() = PokemonsScreenState.PokemonUI(
    name = name,
    number = number,
    imageUrl = imageUrl,
    firstType = firstType,
    secondType = secondType
)