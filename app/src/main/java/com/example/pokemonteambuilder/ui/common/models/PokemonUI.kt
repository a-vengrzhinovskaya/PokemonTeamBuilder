package com.example.pokemonteambuilder.ui.common.models

import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType
import com.example.pokemonteambuilder.domain.pokemons.models.Pokemon

data class PokemonUI(
    val name: String = "",
    val number: Int = 0,
    val description: String = "",
    val firstType: PokemonType = PokemonType.NORMAL,
    val secondType: PokemonType? = null,
    val dexImageUrl: String = "",
    val defaultImageUrl: String = "",
    val shinyImageUrl: String = "",
    val cryUrl: String = "",
    val stats: List<Pair<Pokemon.PokemonStat, Int>> = emptyList(),
    val height: Int = 0,
    val weight: Int = 0
)