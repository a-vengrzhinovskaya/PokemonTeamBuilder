package com.example.pokemonteambuilder.domain.pokemons.models

import com.example.pokemonteambuilder.data.network.models.PokemonInfoResponse.Type
import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType

data class Pokemon(
    val name: String,
    val number: Int,
    val firstType: PokemonType,
    val secondType: PokemonType? = null,
    val imageUrl: String,
    val cryUrl: String,
    val stats: List<PokemonStat>,
    val height: Int,
    val weight: Int
) {
    data class PokemonStat(
        val name: String,
        val baseStat: Int
    )
}