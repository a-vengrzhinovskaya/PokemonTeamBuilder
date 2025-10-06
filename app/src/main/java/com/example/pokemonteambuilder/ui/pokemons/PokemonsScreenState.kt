package com.example.pokemonteambuilder.ui.pokemons

import com.example.pokemonteambuilder.ui.common.models.PokemonUI

private const val START_OFFSET = 0

data class PokemonsScreenState(
    val pokemons: List<PokemonUI> = emptyList(),
    val offset: Int = START_OFFSET,
    val isLoading: Boolean = true
)