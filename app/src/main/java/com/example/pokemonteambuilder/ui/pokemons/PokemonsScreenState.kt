package com.example.pokemonteambuilder.ui.pokemons

import com.example.pokemonteambuilder.domain.pokemonTypes.models.PokemonType

data class PokemonsScreenState(
    val pokemons: List<PokemonUI> = emptyList()
) {
    data class PokemonUI(
        val name: String,
        val number: Int,
        val imageUrl: String,
        val firstType: PokemonType,
        val secondType: PokemonType?
    )
}